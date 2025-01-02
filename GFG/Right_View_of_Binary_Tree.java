// User function Template for Java

/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/

class Solution {
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        // add code here.
        
        ArrayList<Integer> res = new ArrayList();
        
        if(root==null){
            return res;
        }
        
        Queue<Node> q = new LinkedList();
        
        q.add(root);
        
        while(q.size()!=0){
            int n = q.size();
            // only add last element of each level
            for(int i=0;i<n;i++){
                Node rem = q.poll();
                if(i==n-1){
                    res.add(rem.data);
                }
                if(rem.left!=null) q.add(rem.left);
                if(rem.right!=null) q.add(rem.right);
            }
        }
        return res;
    }
}
