/*
Problem    : Merge Two Sorted Lists
LeetCode   : https://leetcode.com/problems/merge-two-sorted-lists/

Goal       : Merge two sorted singly linked lists into one sorted list and return its head.

Approach   : Iterative Merge using Dummy Node
------------------------------------------------------------
- Initialize a dummy node (`dummy`) to simplify list attachment.
- Maintain a pointer `sortedList` starting at `dummy`.
- Traverse both lists simultaneously:
    • Compare `list1.val` and `list2.val`.
    • Attach the smaller node to `sortedList.next`.
    • Move the pointer of the list from which the node was taken.
    • Advance `sortedList` forward.
- When one list is exhausted, attach the remainder of the other list to `sortedList.next`.
- Return `dummy.next` as the merged sorted list head.

Why it Works?
- Mimics the merge step of merge sort.
- Efficient one-pass linear merge since both lists are pre-sorted.

Time Complexity   : O(n + m)
    - n = length of list1, m = length of list2
Space Complexity  : O(1)
    - In-place merge, only uses constant auxiliary space.

Example:
Input  : list1 = [1,2,4], list2 = [1,3,4]
Output : [1,1,2,3,4,4]

Author   : Teja Nayani
Date     : 21 October, 2025
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
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode sortedList = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                sortedList.next = list1;
                list1 = list1.next;
            }else{
                sortedList.next = list2;
                list2 = list2.next;
            }
            sortedList = sortedList.next;
        }
        sortedList.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}