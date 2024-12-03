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
    public ListNode partition(ListNode head, int x) {

        // brutte force with space
        // ListNode temp = head;

        // ArrayList<Integer> bigger = new ArrayList();
        // ArrayList<Integer> smaller = new ArrayList();
        // while (temp != null) {
        //     if (temp.val >= x) {
        //         bigger.add(temp.val);
        //     } else {
        //         smaller.add(temp.val);
        //     }
        //     temp = temp.next;
        // }

        // smaller.addAll(bigger);
        // int j = 0;
        // temp = head;
        // while (temp != null) {
        //     temp.val = smaller.get(j);
        //     temp = temp.next;
        //     j++;
        // }

        // return head;


        ListNode d1 = new ListNode(-1000);
        ListNode d2 = new ListNode(-1000);
        ListNode p1 = d1;
        ListNode p2 = d2;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val<x){
                p1.next = temp;
                p1 = p1.next;
            }else{
                p2.next = temp;
                p2 = p2.next;
            }
            temp = temp.next;
        }

        p1.next = d2.next;
        p2.next = null;

        return d1.next;
    }
}