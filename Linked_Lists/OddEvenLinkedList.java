/*
Problem    : Odd Even Linked List
LeetCode   : https://leetcode.com/problems/odd-even-linked-list/

Goal       : Group all odd-indexed nodes together followed by even-indexed nodes, 
             maintaining the original relative order within each group.

Approach   : Two-Pointer Re-linking (Odd & Even Heads)
------------------------------------------------------------
1. Use two pointers — `odd` for odd-positioned nodes and `even` for even-positioned nodes.
2. Maintain a reference to the head of even nodes (`evenHead`) to reconnect later.
3. Traverse the list:
   - Link odd nodes together: odd.next = odd.next.next
   - Link even nodes together: even.next = even.next.next
4. After traversal, attach the even list after the odd list (`odd.next = evenHead`).

Time Complexity   : O(n)     – single traversal of the list
Space Complexity  : O(1)     – in-place reordering without extra space

Example:
Input  : [1,2,3,4,5]
Output : [1,3,5,2,4]

Author   : Teja Nayani
Date     : 23 October, 2025
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
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = head, even = head.next, evenHead = head.next;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
