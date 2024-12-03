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
    public int countNodes(ListNode head){
        ListNode temp = head;
        int i = 0;
        while(temp!=null){
            i++;
            temp = temp.next;
        }

        return i;
    }
    public int pairSum(ListNode head) {
        int n = countNodes(head);

        int twinLen = (n/2)-1;

        int sum[] = new int[n+1];
   
   
        int i =0;
        ListNode temp = head;
        while(temp!=null){
            if(i<=twinLen){
                sum[n-i-1] = temp.val;
            }else{
                break;
            }
            temp = temp.next;
            i++;
        }
        
        int max = -1;
        while(temp!=null){
            if(i>=sum.length){
                break;
            }else{
                sum[i]+=temp.val;
                max = Math.max(sum[i], max);
            }

            temp = temp.next;
            i++;
        }

        return max;
    }
}