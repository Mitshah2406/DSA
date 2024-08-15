/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node temp = head;
        Node lastValid = null;
        boolean is9 = false;
        while(temp.next!=null){
            sb.append(temp.data);
            if(dummy.data==9) is9=true;
            if(temp.data<9) lastValid = temp; 
            temp = temp.next;
            dummy = dummy.next;
        }
        if(temp.data==9){
            if(!is9){
                if(dummy.data!=-1){
                    dummy.data +=1;
                temp.data=0;
                }else{
                    temp.data+=1;
                }
            }else{
                if(lastValid==null){
                    head.data+=1;
                    Node t1 = head.next;
                    while(t1!=null){
                        t1.data=0;
                        t1 = t1.next;
                    }
                }else{
                    lastValid.data+=1;
                    lastValid = lastValid.next;
                    while(lastValid!=null){
                        lastValid.data = 0;
                        lastValid = lastValid.next;
                    }
                }
            }
        }else{
            temp.data = temp.data+1;
        }
        
        return head;
    }
}
