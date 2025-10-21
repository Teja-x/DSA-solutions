/*
Problem    : Linked List Cycle
LeetCode   : https://leetcode.com/problems/linked-list-cycle/

Goal       : Determine if a linked list has a cycle.

Approach   : Floyd’s Tortoise and Hare Algorithm (Two Pointers)
------------------------------------------------------------
- Initialize two pointers: `slow` and `fast`, both starting at `head`.
- Move `slow` by one step and `fast` by two steps in each iteration.
- If the linked list has a cycle, the two pointers will eventually meet.
- If `fast` or `fast.next` becomes null, it means the list has an end — hence no cycle.

Why it Works?
- A cycle ensures that a faster-moving pointer will “lap” a slower one.
- If they ever meet, it confirms the presence of a loop in the list.

Time Complexity   : O(n)
Space Complexity  : O(1)

Example:
Input  : head = [3,2,0,-4], pos = 1
Output : true
Explanation: The tail connects to the second node, forming a cycle.

Author   : Teja Nayani
Date     : 21 October, 2025
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}