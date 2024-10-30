//User function Template for Java



//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{   //Brute Force
    void inorder(Node root, ArrayList<Node> arr){
        if(root==null) return;
        
        inorder(root.left, arr);
        root.left=null;
        arr.add(root);
        inorder(root.right, arr);
        root.right=null;
    }
    Node bTreeToClist(Node root)
    {   
        // Brute Force
       ArrayList<Node> arr = new ArrayList<>();
       inorder(root, arr);
       
       int n = arr.size();
       Node prev = null;
       for(int i=0;i<n-1;i++){
          Node no = arr.get(i);
          no.left = prev;
          no.right = arr.get(i+1);
          prev = no;
       }
       
       Node last = arr.get(n-1);
       last.left = arr.get(n-2);
       Node first = arr.get(0);
       first.left = last;
       last.right = first;
       
       return first;
    }
    
}
    
