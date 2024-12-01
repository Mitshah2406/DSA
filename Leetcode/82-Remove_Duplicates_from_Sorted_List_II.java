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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1000);
        ListNode temp = head;
        dummy.next = head;

        ListNode prev = dummy;
        ListNode firstOcc = null;
        ListNode firstPrevOcc = null;

        while (temp != null) {
            if (prev.val != temp.val) {
                ListNode t1 = temp.next;
                if (t1 != null && t1.val == temp.val) {
                    while (t1 != null && t1.val == temp.val) {
                        t1 = t1.next;
                    }
                    prev.next = t1;
                    temp = t1;
                } else {
                    prev = temp;
                    temp = temp.next;
                }
            }
        }

        return dummy.next;
    }
}