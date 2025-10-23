/*
Problem    : Palindrome Linked List
LeetCode   : https://leetcode.com/problems/palindrome-linked-list/

Goal       : Determine whether a singly linked list is a palindrome.

Approach   : Reverse First Half + Two-Pointer Comparison
------------------------------------------------------------
1. Use slow and fast pointers to reach the midpoint of the list.  
   - Move `slow` by 1 step and `fast` by 2 steps.
   - Simultaneously, reverse the first half of the list in-place during traversal.
2. After reaching the midpoint:
   - If `fast` is not null (odd-length list), move `slow` one step ahead to skip the middle node.
3. Compare the reversed left half (`prev`) and the remaining right half (`slow`).
   - If any pair of nodes mismatch, return false.
4. If all nodes match, return true.

Why This Works:
- The first half is reversed while finding the midpoint, avoiding extra passes or space.
- Only O(1) extra memory is used.

Time Complexity   : O(n)
Space Complexity  : O(1)

Example:
Input  : [1,2,2,1]
Output : true

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
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        ListNode right = (fast == null) ? slow : slow.next;
        ListNode left = prev;
        while(right != null){
            if(left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}