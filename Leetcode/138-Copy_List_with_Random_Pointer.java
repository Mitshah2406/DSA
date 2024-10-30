/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node clonedList(Node head, ArrayList<Node> arr) {
        Node dummy = new Node(-1);
        Node h2 = dummy;
        Node temp = head;

        while (temp != null) {
            Node newNode = new Node(temp.val);
            dummy.next = newNode;
            dummy = newNode;
            newNode.random = temp;
            temp = temp.next;
        }

        Node temp1 = head;
        Node temp2 = h2.next;
        while (temp1 != null && temp2!=null) {
            arr.add(temp1);
            Node tp = temp1.next;
            temp1.next = temp2;
            temp2 = temp2.next;
            temp1 = tp;
        }
        return h2.next;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        ArrayList<Node> arr = new ArrayList();
        Node h2 = clonedList(head, arr);


        Node temp = h2;

        while(temp!=null){
            Node ogNode = temp.random;
            if(ogNode.random == null){
                temp.random=null;
            }else{
                Node newRandom = ogNode.random.next;
                temp.random = newRandom;
            }
            temp = temp.next;
        }
        int n = arr.size();
        for(int i=0;i<n-1;i++){
            Node t = arr.get(i);
            t.next = arr.get(i+1);
        }
        arr.get(n-1).next = null;
        return h2;
    }
}