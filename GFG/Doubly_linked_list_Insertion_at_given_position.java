/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        Node toAdd = new Node(x);
        Node temp = head;
        int idx = 0;
        while(temp!=null){
            if(idx==p){
                break;
            }
            idx++;
            temp = temp.next;
        }
        
        Node after = temp.next;
        
        if(after!=null){
            after.prev = toAdd;
        }
        
        toAdd.next = after;
        temp.next = toAdd;
        toAdd.prev = temp;
        
        return head;
    }
}