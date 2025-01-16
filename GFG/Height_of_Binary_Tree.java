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
    // Function to find the height of a binary tree.
    static int ans = 0;
    public void preorder(Node root, int ht){
        if(root==null){
            return;
        }
        ans = Math.max(ans, ht);
        preorder(root.left,ht+1);
        preorder(root.right,ht+1);
        
        
    }
    int height(Node node) {
        ans = 0;
        preorder(node, 0);
        return ans;
    }
}
