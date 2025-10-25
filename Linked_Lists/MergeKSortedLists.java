/*
Problem     : Merge k Sorted Lists
LeetCode    : https://leetcode.com/problems/merge-k-sorted-lists/

Goal:
Given an array of k sorted linked lists, merge them into one sorted linked list and return it.

Approach: Divide & Conquer (Pairwise Merge)
----------------------------------------------------
1) Instead of merging lists one-by-one (which is slower), we merge in pairs.
2) interval = 1 means merge (0,1), (2,3), (4,5) ...
   interval = 2 means merge (0,2), (4,6) ...
   interval doubles every round → reduces total merges significantly.
3) Each pair merge is performed using standard sorted list merge logic.
4) Continue until only one list remains.

Why is this good?
- Turns k-way merge into log-k merge rounds.
- Reduces repeated work compared to merging sequentially.

Time Complexity:
- Each merge of two lists: O(n)
- Number of rounds: O(log k)
→ Total = O(n log k)    (Optimal)

Space Complexity:
- O(1) extra (merges are done in-place).

----------------------------------------------------

Alternate Approach: Min-Heap (Priority Queue)
----------------------------------------------------
1) Push the head of each list into a min-heap (sorted by node value).
2) Repeatedly poll the smallest node and push its next pointer.
3) Build the result list as we pop.

Time Complexity : O(n log k)
Space Complexity: O(k) heap

----------------------------------------------------
Summary:
- Both approaches have optimal O(n log k) time.
- Divide & Conquer uses less extra memory → preferred in interviews.

Author  : Teja Nayani
Date    : 25 October, 2025
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedLists {
    private ListNode merge(ListNode l1, ListNode l2){
        // standard merge of two sorted linked lists
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2; // attach the remaining part (only one of them is non-null)

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        int k = lists.length;
        int interval = 1; // distance between pairs to merge in each round

        // keep merging pairs of lists: (0,1), (2,3) -> then (0,2), (4,6), etc
        while(interval < k){
            for(int i = 0; i + interval < k; i += interval*2){ // i jumps by 2*interval so we merge disjoint pairs
                lists[i] = merge(lists[i], lists[i + interval]); // merge lists[i] with lists[i + interval]
            }
            interval *= 2; // double the pairing distance for next round
        }
        return lists[0]; // final merged list is stored at index 0

        /*
        int k = lists.length;
        if(k == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        // push only non-null list heads
        for(int i = 0; i < k; i++){
            if(lists[i] != null)
                minHeap.offer(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll(); // smallest node - since minHeap.poll() gives us the smallest node
            tail.next = node;   // add the node to answer(tail)
            tail = tail.next;

            if(node.next != null){  // push the next node of the same poll(ed) list if it is not null
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
        */
    }
}