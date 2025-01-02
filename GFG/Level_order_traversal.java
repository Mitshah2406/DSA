// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    // Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node root) {
        Queue<Node> q = new LinkedList();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        q.add(root);
        
        while(q.size()!=0){
            int n = q.size();
            for(int i=0;i<n;i++){
                Node rem = q.remove();
                arr.add(rem.data);
                if(rem.left!=null){
                    q.add(rem.left);
                }
                if(rem.right!=null){
                    q.add(rem.right);
                }
            }
        }
        return arr;
    }
}
