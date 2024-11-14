//User function Template for Java

class Solution{
    Node removeDuplicates(Node head){
        // Code Here.
        
        Node temp = head.next;
        Node firstOcc = head;
        
        
        while(temp!=null){
            if(firstOcc.data==temp.data){
                    firstOcc.next = temp.next;
                    if(temp.next!=null){temp.next.prev = firstOcc;}
            }else{
                firstOcc = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}