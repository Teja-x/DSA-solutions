/*
Problem    : Linked List Cycle II
LeetCode   : https://leetcode.com/problems/linked-list-cycle-ii/

Goal       : Find the node where the cycle begins in a linked list, or return null if there is no cycle.

Approach   : Floyd’s Cycle Detection Algorithm (Tortoise and Hare)
------------------------------------------------------------
Step 1: Detect Cycle
- Use two pointers: `slow` and `fast`, both starting at `head`.
- Move `slow` by 1 step and `fast` by 2 steps.
- If they meet, a cycle exists.
- If `fast` or `fast.next` becomes null, the list has no cycle → return null.

Step 2: Find Start of Cycle
- Once a meeting point is found, initialize a new pointer `tail` at `head`.
- Move both `slow` and `tail` one step at a time.
- The node where they meet again is the start of the cycle.

Why it Works?
- Let `a` = distance from head to start of cycle, `b` = distance from cycle start to meeting point, and `c` = remaining cycle length.
- When fast moves twice as fast as slow, it covers `2(a + b)` while slow covers `(a + b)`.
- Solving gives `a = c - b`, meaning moving `a` steps from head and meeting point leads to cycle start.

Time Complexity   : O(n)
Space Complexity  : O(1)

Example:
Input  : head = [3,2,0,-4], pos = 1
Output : tail connects to node index 1 (value 2)

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
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head, tail = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(fast == null || fast.next == null)
            return null;

        while(tail != slow){
            tail = tail.next;
            slow = slow.next;
        }
        return tail;
    }
}