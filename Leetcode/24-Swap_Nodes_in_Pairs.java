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
    public void swap(ListNode prev, ListNode f, ListNode s) {
        ListNode after = s.next;

        prev.next = s;
        s.next = f;
        f.next = after;
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (temp != null) {
            ListNode first = temp;
            ListNode second = temp.next;

            if (second != null) {
                swap(prev, first, second);
            }
            prev = first;
            temp = first.next;
        }

        return dummy.next;
    }
}