/*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    Node merge(Node h1, Node h2){
        Node i = h1;
        Node j = h2;
        Node k = new Node(-1);
        Node t = k;
        while(i!=null && j!=null){
            if(i.data<=j.data){
                Node temp = new Node(i.data);
                t.next = temp;
                t = t.next;
                i = i.next;
            }else{
                Node temp = new Node(j.data);
                t.next = temp;
                t = t.next;
                j = j.next;
            }
        }
        
        while(i!=null){
            Node temp = new Node(i.data);
            t.next = temp;
            t = t.next;
            i = i.next;
        }
        while(j!=null){
            Node temp = new Node(j.data);
            t.next = temp;
            t = t.next;
            j = j.next;
        }
        
        return k.next;
    }
    Node sortedMerge(Node head1, Node head2) {
        return merge(head1,head2);
    }
}
