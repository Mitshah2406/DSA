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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;

        int i = 1;
        temp = head;

        ListNode prev = new ListNode(-1);

        ListNode evenHead = new ListNode(-1);
        ListNode evenTemp = evenHead;
        ListNode oddHead = new ListNode(-1);
        ListNode oddTemp = oddHead;
        while (temp != null) {
            if (i % 2 == 1) { // even
                oddTemp.next = temp;
                temp = temp.next;
                oddTemp = oddTemp.next;
                oddTemp.next = null;

            } else { // odd
                evenTemp.next = temp;
                temp = temp.next;
                evenTemp = evenTemp.next;
                evenTemp.next = null;
            }

            i++;
        }
        oddTemp.next = evenHead.next;

        return oddHead.next;
    }
}