/*
Problem    : Reorder List
LeetCode   : https://leetcode.com/problems/reorder-list/

Goal       : Reorder a singly linked list so that the nodes are arranged as:
             L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

Approach   : Find Middle + Reverse Second Half + Merge Two Halves
------------------------------------------------------------
1. Use the slow and fast pointer method to find the middle of the list.
2. Reverse the second half of the list starting from the node after `slow`.
3. Merge the two halves:
   - Alternate nodes from the first half (`head`) and the reversed second half.
   - Continue until the second half is exhausted.

Why It Works:
- The middle node acts as a pivot.
- Reversing the second half prepares it for alternating merge without extra space.
- In-place reordering ensures O(1) space complexity.

Time Complexity   : O(n)
Space Complexity  : O(1)

Example:
Input  : [1,2,3,4,5]
Output : [1,5,2,4,3]

Author   : Teja Nayani
Date     : 22 October, 2025
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
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
            
        ListNode slow = head, fast = head, first, second, prev;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev = null;
        second = slow.next;
        slow.next = null;
        while(second != null){
            ListNode nextNode = second.next;
            second.next = prev;
            prev = second;
            second = nextNode;
        }

        first = head;
        second = prev;
        while(second != null){
            ListNode l1 = first.next;
            ListNode l2 = second.next;
            first.next = second;
            second.next = l1;
            first = l1;
            second = l2;
        }
    }
}
