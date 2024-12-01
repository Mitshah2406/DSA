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
    public ListNode merge(ListNode h1, ListNode h2) {
        if(h1 == null) return h2;
        else if(h2 == null) return h1;
        ListNode t = null;
        ListNode ans = null;

        if (h1.val <= h2.val) {
            t = h1;
            ans = h1;
            h1 = h1.next;
        } else {
            t = h2;
            ans = h2;
            h2 = h2.next;
        }

        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                t.next = h1;
                h1 = h1.next;
                t = t.next;
            } else {
                t.next = h2;
                h2 = h2.next;
                t = t.next;
            }
        }

        while (h1 != null) {
            t.next = h1;
            h1 = h1.next;
            t = t.next;
        }
        while (h2 != null) {
            t.next = h2;
            h2 = h2.next;
            t = t.next;
        }
        return ans;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return lists[0];
        } else {
            Stack<ListNode> st = new Stack();
            for(ListNode l : lists){
                if(l==null) continue;
                st.push(l);
            }
            if(st.size()==0){
                return null;
            }else if(st.size()==1){
                return st.peek();
            }
            while(st.size()!=1){
                ListNode f = st.pop();
                ListNode s = st.pop();
                ListNode res = merge(f,s);
                st.push(res);
            }

            return st.peek();
        }
    }
}