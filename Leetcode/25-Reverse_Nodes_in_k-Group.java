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
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode currP1 = null;
        ListNode prev = null;

        while (curr != null) {
            currP1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currP1;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;

        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int reversals = (int)Math.floor(size / k);
        ListNode ltHead = head;
        ListNode overallHead = head;
        ListNode nextList = null;
        ListNode prevPartTail= null;
        for (int i = 0; i < reversals; i++) {
            temp = ltHead;
            ListNode h1 = ltHead;
            int th = 0;
            while (temp != null) {
                if (th == k - 1) {
                    nextList = temp.next;
                    temp.next = null;
                    break;
                }
                temp = temp.next;
                th++;
            }

            ListNode h2 = reverse(h1);
            ltHead = nextList;
            if (i != 0) {
                prevPartTail.next = h2;
            }else{
                overallHead = h2;
            }
            prevPartTail = h1;
        }

        prevPartTail.next = nextList;

        return overallHead;
    }
}
