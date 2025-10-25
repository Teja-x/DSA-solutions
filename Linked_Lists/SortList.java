/*
Problem      : Sort List (Linked List Merge Sort)
LeetCode     : https://leetcode.com/problems/sort-list/

Goal:
Sort a singly linked list in ascending order.

Key Idea:
Use Merge Sort — it works naturally on linked lists because:
- Splitting the list is O(n) using fast/slow pointers.
- Merging two sorted lists is O(n).
- No random access needed (unlike QuickSort).

Approach: Top-Down Merge Sort (Recursive)
-------------------------------------------------
1) Base Case:
   If head is null or single node → already sorted → return it.

2) Split the List into Two Halves:
   Use slow & fast pointers to find the mid.
   `prev.next = null` breaks the list into:
      left half  = head → prev
      right half = slow → end

3) Recursively Sort Each Half:
      left  = sortList(head)
      right = sortList(slow)

4) Merge Two Sorted Halves:
   Use a standard sorted merge of two linked lists.
   Return the head of the merged list.

Time Complexity: O(n log n)
   - log n splits
   - each merge is O(n)

Space Complexity: O(log n)
   - recursion stack (implicit)

Author: Teja Nayani
Date  : 24 October, 2025
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
class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head, prev = null;        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        return merge(left, right);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}