/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Brute force shift all later values by 1 step forward and then remove last node
        // we cant remvoe this specific node but can remove next by copying next ki
        // value into curr(node)
        ListNode nextNode = node.next;

        node.val = nextNode.val;

        node.next = nextNode.next;

    }
}