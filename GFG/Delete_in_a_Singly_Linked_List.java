/* Linklist node structure
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {
    Node deleteNode(Node head, int x) {
       if(x==1){
          head = head.next;
          return head;
       }
       
       Node dummy = new Node(-1);
       Node temp = head;
       dummy.next = head;
       int pos = 0;
       while(temp!=null){
           dummy = dummy.next;
           temp = temp.next;
           pos++;
           if(pos==x-1){
               break;
           }
       }
       
       dummy.next = temp.next;
       temp.next = null;
       
       return head;
    }
}