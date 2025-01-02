// User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res = new ArrayList();
        if(root==null){
            return res;
        }
        Queue<Node> q = new LinkedList();
        
        q.add(root);
        while(q.size()!=0){
            int n = q.size();
            
            for(int i=0;i<n;i++){
                Node rem = q.poll();
        // only add the first element of each level
                if(i==0){
                    res.add(rem.data);
                }
                if(rem.left!=null) q.add(rem.left);
                if(rem.right!=null) q.add(rem.right);
            }
        }
        return res;
    }
}