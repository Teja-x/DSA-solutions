/*
Problem    : Reverse Linked List
LeetCode   : https://leetcode.com/problems/reverse-linked-list/

Goal       : Reverse a singly linked list and return the new head.

Approach   : Recursion (Primary) + Iterative (Alternative)
------------------------------------------------------------
Recursive Approach:
- Base Case: If head is null or only one node → return head.
- Recursively call `reverseList(head.next)` to reverse the rest of the list.
- Make `head.next.next = head` to reverse the link.
- Set `head.next = null` to break the existing forward link.
- Return the new head of the reversed list from recursion.

Iterative Approach:
- Initialize `prev = null` and `curr = head`.
- While traversing:
    • Save next node (`nextNode = curr.next`)
    • Reverse pointer (`curr.next = prev`)
    • Move forward (`prev = curr`, `curr = nextNode`)
- Return `prev` as new head.

Why it Works?
- Recursion unwinds from the end, reversing links bottom-up.
- Iteration reverses in one pass, adjusting pointers directly.

Time Complexity   : O(n)
Space Complexity  : O(1) (iterative) / O(n) recursion stack (recursive)

Example:
Input  : 1 → 2 → 3 → 4 → 5 → null
Output : 5 → 4 → 3 → 2 → 1 → null

Author   : Teja Nayani
Date     : 21 October, 2025
*/

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
*/
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //Recursive Approach
        if(head == null || head.next == null)
            return head;
        
        ListNode newNode = reverseList(head.next);

        head.next.next = head; //to reverse
        head.next = null; //to break link 

        return newNode;

        /* -Iterative Approach
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode nextNode = curr.next; //preserve next node state
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
        */
    }
}