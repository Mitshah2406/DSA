/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode breakLL(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode h2 = null;
        h2 = slow.next;
        slow.next = null;

        return h2;
    }

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode currP1 = head.next;

        while (currP1 != null) {
            curr.next = prev;
            prev = curr;
            curr = currP1;
            currP1 = currP1.next;
        }

        curr.next = prev;
   

        return curr;
    }

    public void reorderList(ListNode head) {

        // first find mid then break into two lists
        // reverse second list 

        // continue merging them
        if(head.next==null){
            return;
        }
        ListNode h2 = breakLL(head);

        ListNode revH2 = reverseLL(h2);

        ListNode t1 = head;
        ListNode t2 = revH2;
        while(t1!=null && t2!=null){
            ListNode t1p1 = t1.next;
            ListNode t2p1 = t2.next;
            t1.next = t2;
            t2.next = t1p1;

            t1 = t1p1;
            t2 = t2p1;
        }

    }
}