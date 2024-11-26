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
    public int[] nextLargerNodes(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while(temp!=null){
            count++;
            temp = temp.next;
        }
        int nser[] = new int[count];
        Stack<int[]> st = new Stack();
        int i=0;
        temp = head;
        while(temp!=null){
            int curr = temp.val;
            while(!st.isEmpty() && curr > st.peek()[0]){
                int[] pair = st.pop();
                nser[pair[1]] = curr;
            }
            st.push(new int[]{curr, i});
            temp = temp.next;
            i++;
        }

        return nser;
    }
}