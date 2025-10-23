/*
Problem    : Remove Nth Node From End of List
LeetCode   : https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Goal       : Remove the nth node from the end of a singly linked list and return its head.

Approach   : Two Pointer Technique (Fast and Slow)
------------------------------------------------------------
1. Create a dummy node pointing to the head — helps handle edge cases (like removing the first node).
2. Move the `fast` pointer `n` steps ahead of the `slow` pointer.
3. Move both pointers one step at a time until `fast` reaches the last node.
4. `slow` will now be just before the target node — remove it by skipping `slow.next`.
5. Return `dummy.next` as the new head.

Why Dummy Node?
- Simplifies handling of edge cases, especially when the head itself is removed.

Time Complexity   : O(n)
Space Complexity  : O(1)

Example:
Input  : head = [1,2,3,4,5], n = 2  
Output : [1,2,3,5]

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
class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        for(int i = 0; i < n; i++){
            fast = fast.next; //reassigning reference to next
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}