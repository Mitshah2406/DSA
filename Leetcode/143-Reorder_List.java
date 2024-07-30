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
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = head;
        ListNode mid = slow;

        mid = reverseList(mid);

        ListNode temp1 = mid;
        ListNode nxt1 = null;

        ArrayList<ListNode> arr = new ArrayList();

        while (temp1 != null) {
            arr.add(temp1);
            temp1 = temp1.next;
        }
        int i = 0;
        while (temp != null && i < arr.size()) {
            nxt1 = temp.next;

            temp.next = arr.get(i);

            i++;
            temp = temp.next;
            temp.next= nxt1;
            temp = temp.next;
        }

    }
}