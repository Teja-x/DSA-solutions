/*
Problem    : Add Two Numbers
LeetCode   : https://leetcode.com/problems/add-two-numbers/

Goal       : Add two non-empty linked lists representing two non-negative integers.
             Each node contains a single digit, and the digits are stored in reverse order.
             Return the sum as a linked list.

Approach   : Iterative Addition with Carry
------------------------------------------------------------
1. Initialize a dummy node to build the result list.
2. Traverse both lists simultaneously, adding corresponding digits along with any carry.
3. If one list is shorter, treat its missing digits as 0.
4. Compute:
   - sum = (carry + val1 + val2)
   - carry = sum / 10
   - node value = sum % 10
5. Continue until both lists and carry are processed.
6. Return dummy.next as the head of the resultant linked list.

Time Complexity   : O(max(m, n))     // where m and n are the lengths of the two lists
Space Complexity  : O(max(m, n))     // for the new result list

Example:
Input  : l1 = [2,4,3], l2 = [5,6,4]
Output : [7,0,8]

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
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int sum = 0, carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = (sum > 9) ? 1 : 0; // carry = sum/10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        return dummy.next;
    }
}