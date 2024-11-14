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
        ListNode prev = null;

        ListNode currP1 = head;
        ListNode curr = head;
        while (curr != null) {
            currP1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currP1;
        }

        return prev;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;

        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (size <= 1) {
            return head;
        }
        k = k % size;

        ListNode h1 = reverse(head);
        temp = h1;
        int br = 0;
        ListNode secondHalf = null;
        while (temp != null) {
            br++;
            if (br == k) {
                secondHalf = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }

        ListNode h2 = reverse(h1);
        ListNode h3 = reverse(secondHalf);
        h1.next = h3;

        return h2;
    }
}