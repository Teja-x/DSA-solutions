/*
Problem      : Remove Duplicates from Sorted List II
LeetCode     : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

Goal:
Given the head of a sorted linked list, remove all nodes that have duplicate values,
so that only distinct numbers remain.

Example:
Input  : 1 → 2 → 3 → 3 → 4 → 4 → 5
Output : 1 → 2 → 5

Approach:
----------------------------------------------------
1) Use a dummy node to handle deletions at the head safely.
2) Maintain two pointers:
      prev → last confirmed unique node
      curr → iterator pointer scanning ahead
3) If curr has duplicates (curr.val == curr.next.val):
      - Store the duplicate value.
      - Move curr forward until all nodes with that value are skipped.
      - Link prev.next to curr (removing duplicates entirely).
4) Else:
      - Move prev to curr (confirm uniqueness).
      - Move curr ahead normally.
5) Return dummy.next.

Why dummy node?
- Ensures correct handling when the first few nodes are duplicates.

Time Complexity   : O(n)
Space Complexity  : O(1)

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
class RemoveDuplicatesFromSortedListsII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        //ListNode dummy = new ListNode(0);
        ListNode dummy = new ListNode(0, head); // i.e dummy.next = head;
        ListNode prev = dummy, curr = head;
        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                int dup = curr.val;
                while(curr != null && curr.val == dup){
                    curr = curr.next;
                }
                prev.next = curr;
            }else{
                //prev.next = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}