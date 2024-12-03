/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode intersectionFloyd(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        while (temp.next != null) {
            temp = temp.next;
        }
        ListNode tail = temp;

        tail.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            tail.next = null;
            return null;
        }

        fast = headA;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        tail.next = null;

        return slow;
    }

    public int getSize(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Brute floyd cycle approach
        // return intersectionFloyd(headA, headB);

        // More optimal
        int sA = getSize(headA);
        int sB = getSize(headB);
        ListNode getStartA = headA;
        ListNode getStartB = headB;
        int diff = Math.abs(sA - sB);
        if (sA > sB) {
            for (int i = 0; i < diff; i++) {
                getStartA = getStartA.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                getStartB = getStartB.next;
            }
        }

        while (getStartA != null && getStartB != null) {
            if (getStartA == getStartB) {
                return getStartA;
            }

            getStartA = getStartA.next;
            getStartB = getStartB.next;
        }

        return null;

    }
}