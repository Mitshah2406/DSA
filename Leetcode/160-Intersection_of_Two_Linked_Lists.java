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
        int sA = getSize(headA);
        int sB = getSize(headB);
        ListNode getStartA = null;
        ListNode getStartB = null;
        if (sA > sB) {
            ListNode temp = headA;
            getStartB = headB;
            int i = 0;
            while (temp != null) {
                if (i == (sA - sB)) {
                    getStartA = temp;
                    break;
                }
                i++;
                temp = temp.next;
            }
        } else {
            ListNode temp = headB;
            int i = 0;
            getStartA = headA;
            while (temp != null) {
                if (i == (sB - sA)) {
                    getStartB = temp;
                    break;
                }
                i++;
                temp = temp.next;
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