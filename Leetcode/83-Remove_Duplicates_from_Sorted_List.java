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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode firstOcc = null;
        // find first occ then skip all dup occurences in between as list is already sorted
        while (temp != null) {
                firstOcc = temp;
                while (temp != null && temp.val == firstOcc.val) {
                    temp = temp.next;
                }
                firstOcc.next = temp;
        }

        return head;
    }
}