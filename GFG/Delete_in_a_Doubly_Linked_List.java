/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        if(x==1){
            head = head.next;
            head.prev = null;
            return head;
        }
        
        
        int count = 1;
        
        Node temp = head.next;
        
        while(temp!=null){
            count++;
            if(count==x){
                Node p = temp.prev;
                Node n = temp.next;
                
                temp.prev = null;
                if(n!=null){
                    n.prev = p;
                }
                p.next = n;
                break;
            }else{
                temp = temp.next;
            }
            
        }
        return head;
    }
}
