/*
Problem    : Intersection of Two Linked Lists
LeetCode   : https://leetcode.com/problems/intersection-of-two-linked-lists/

Goal       : Find the node where two singly linked lists intersect. 
             Return null if there is no intersection.

Approach   : Length Difference Alignment
------------------------------------------------------------
1. Calculate the lengths of both lists (aLen, bLen) by traversing each once.
2. Identify the longer list and advance its pointer by the length difference (|aLen - bLen|).
   - This ensures both pointers have equal remaining nodes to traverse.
3. Move both pointers (shorter and longer) one step at a time.
   - The first node where they meet is the intersection point.
4. If they reach null simultaneously, there is no intersection.

Alternate Approach (Cycle Trick):
- Temporarily connect the tail of List A to the head of List B.
- Detect the cycle using Floyd’s cycle detection algorithm.
- Restore the list structure and return the cycle entry if found.

Time Complexity   : O(m + n)
Space Complexity  : O(1)

Example:
Input  : A = [4,1,8,4,5], B = [5,6,1,8,4,5]
Output : Intersected at '8'

Author   : Teja Nayani
Date     : 23 October, 2025
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Canonical/Optimal Approach : Length Difference Alignment
        int aLen = 0, bLen = 0;
        ListNode tailA = headA, tailB = headB;
        while(tailA != null || tailB != null){ //or count lengths of both lists separately using two separate while loops - either works
            if(tailA != null){
                aLen++;
                tailA = tailA.next;
            }
            if(tailB != null){
                bLen++;
                tailB = tailB.next;
            }
        }
        ListNode shorter = (aLen < bLen) ? headA : headB;
        ListNode longer = (aLen < bLen) ? headB : headA;

        int excess = Math.abs(aLen - bLen);
        for(int i = 0; i < excess; i++){
            longer = longer.next;
        }
        while(shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;

        /* Alternative conceptual approach - Cycle Trick - converting to Linked List Cycle II
        ListNode tail = headA, start = headA;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = headB;

        ListNode slow = headA, fast = headA;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(fast == null || fast.next == null){
            tail.next = null;
            return null;
        }
        
        while(start != slow){
            start = start.next;
            slow = slow.next;
        }
        tail.next = null;

        return slow;
        */
    }
}
