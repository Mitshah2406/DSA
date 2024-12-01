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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode dummy = prev;
        ListNode temp = head;

        while(temp!=null){
            if(temp.val==val){
                prev.next = temp.next;
                temp.next = null;
                temp = prev.next;
            }else{
                prev = prev.next;
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}