/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode currP1 = head.next;

        while(currP1!=null){
            curr.next = prev;
            prev = curr;
            curr = currP1;
            currP1 = currP1.next;
        }

        curr.next = prev;

        return curr;
    }
}