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
 //atharva bhadwa
class Solution {
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = new ListNode(-1);
        ListNode temp = p3;
        while (p1 != null && p2 != null) {
            if (p1.val >= p2.val) {
                temp.next = new ListNode(p2.val);
                p2 = p2.next;
            } else {
                temp.next = new ListNode(p1.val);
                p1 = p1.next;
            }
            temp = temp.next;
        }

        if (p1 == null) {
            while (p2 != null) {
                temp.next = new ListNode(p2.val);
                p2 = p2.next;
                temp = temp.next;
            }
        }
        if (p2 == null) {
            while (p1 != null) {
                temp.next = new ListNode(p1.val);
                p1 = p1.next;
                temp = temp.next;
            }
        }

        return p3.next;
    }



    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    public ListNode sortList(ListNode h1) {
        if (h1==null || h1.next==null){
            return h1;
        }
        ListNode mid = findMid(h1);
        ListNode one = h1;
        ListNode two = mid.next;
        mid.next = null;
        one = sortList(one);
        two = sortList(two);
        ListNode t3 = merge(one,two);
        return t3;
    }
}