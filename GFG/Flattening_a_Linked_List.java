/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
	    // Brute Force with auxillary space
	    
	    PriorityQueue<Integer> pq = new PriorityQueue();
	    
	    Node temp = root;
	    
	    while(temp!=null){
	        Node downT = temp;
	        Node prev = null;
	        while(downT!=null){
	            pq.add(downT.data);
	            prev = downT;
	            downT = downT.bottom;
	        } 
	        prev.bottom = temp.next;
	        if(temp.next!=null){
	            temp.next = null;
	        }
	        temp = prev.bottom;
	    }
	   // System.out.println("PQ" + pq);
	    Node t1 = root;
	    while(pq.size()!=0){
	        int rem = pq.remove();
	        t1.data = rem;
	        t1 = t1.bottom;
	    }
	   
	   
	   
	    return root;
	    
    }
}