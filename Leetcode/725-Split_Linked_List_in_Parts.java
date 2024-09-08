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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        // Arrays.fill(ans, null);
        ListNode temp = head;
        int linkedListLen = 0;
        while (temp != null) {
            linkedListLen++;
            temp = temp.next;
        }
        if (k >= linkedListLen) {
            temp = head;
            int i = 0;
            while (temp != null) {
                ans[i] = temp;
                ListNode prev = temp;
                temp = temp.next;
                prev.next = null;
                i++;
            }
        } else {
            int rem = linkedListLen % k;
            int divisor = linkedListLen / k;
            temp = head;
            
            int kCount = 0;

            while(kCount<k){
                int listLen = divisor;
                if(rem>0){
                    listLen +=1;
                    rem-=1;
                }
                temp = head;
                ListNode stPt = temp;
                for(int m=0;m<listLen-1;m++){
                    temp = temp.next;
                }
                ans[kCount] = stPt;
                head = temp.next;
                temp.next = null;
                kCount++;
            }
        }
        return ans;
    }
}