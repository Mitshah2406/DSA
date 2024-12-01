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
    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode ansH = null;
        ListNode t = null;

        if (h1.val <= h2.val) {
            t = h1;
            ansH = h1;
            h1 = h1.next;
        } else {
            t = h2;
            ansH = h2;
            h2 = h2.next;
        }

        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                t.next = h1;
                h1 = h1.next;
                t = t.next;
            } else {
                t.next = h2;
                h2 = h2.next;
                t = t.next;
            }
        }

        while (h1 != null) {
            t.next = h1;
            h1 = h1.next;
            t = t.next;
        }
        while (h2 != null) {
            t.next = h2;
            h2 = h2.next;
            t = t.next;
        }

        return ansH;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        } else {
            return merge(list1, list2);
        }
    }
}