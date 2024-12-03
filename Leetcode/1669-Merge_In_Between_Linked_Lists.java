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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        // Time - O(n), Space = O(1)
        ListNode temp = list1;
        ListNode nodeA = null; // For the first break point
        ListNode nodeB = null; // For the second break point
        int i = 0; // counter
        while(temp!=null){
            if(i==a-1){
                nodeA=temp;
            }else if(i==b+1){
                nodeB= temp;
            }
            i++;
            temp = temp.next;
        }

        temp = list2; // find the tail of list to be inserted
        while(temp.next!=null){
            temp = temp.next;
        }
        // just connect the list within those found breakpoints properly
        nodeA.next = list2;
        temp.next = nodeB;

        return list1;
    }
}