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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode startK = null;
        ListNode endK = null;
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            n++;
            if(n==k){
                startK = temp;
            }
            temp = temp.next;
        }
        int end = n-k+1;
        int i = 0;
        temp = head;
        while(temp!=null){
            i++;
            if(i==end){
                endK = temp;
                break;
            }
            temp = temp.next;
        }

        int t = startK.val;
        startK.val = endK.val;
        endK.val = t;
        return head;
    }
}