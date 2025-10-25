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
class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;

        int n = 0;
        ListNode newHead = null, lastNode = null, curr = head;
        while(curr != null){
            if(curr.next == null)
                lastNode = curr;
            n++;
            curr = curr.next;
        }

        int kmod = k%n;
        if(kmod == 0)
            return head;

        curr = head;
        for(int i = 0; i < (n-kmod-1); i++){ //-1 because curr becomes curr.next after n-mod steps, so you'll be at newHead and not prev (for which you need to break) 
            curr = curr.next;
        }

        newHead = curr.next;
        curr.next = null;
        lastNode.next = head;

        return newHead;
    }
}