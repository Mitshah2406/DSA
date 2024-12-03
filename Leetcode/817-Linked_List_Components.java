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
    public int numComponents(ListNode head, int[] nums) {
        // HashSet<Integer> hs = new HashSet(); // as all values in both inputs are unique, so use for O(1) retrieval
        // for (int i : nums) {
        //     hs.add(i);
        // }

        // Used 10001 length array as hashset as per constraints
        boolean hs[] = new boolean[10001];
        for(int i:nums){
            hs[i] = true;
        }
        ListNode temp = head;
        int noOfConnectedComponents = 0;
        boolean wasPrevValid = false; // for checking if consecutive components are valid or not
        while (temp != null) {
            if (hs[temp.val]) {
                if (!wasPrevValid) {
                    noOfConnectedComponents++;
                }
                wasPrevValid = true;
            } else {
                wasPrevValid = false;
            }
            temp = temp.next;
        }

        return noOfConnectedComponents;
    }
}