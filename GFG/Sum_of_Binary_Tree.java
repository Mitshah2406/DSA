// User function Template for Java

/*
// A Binary Tree node
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
    // Function to return sum of all nodes of a binary tree
    static int sum = 0;
    private static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        sum+=root.data;
        inorder(root.right);
    }
    static int sumBT(Node root) {
        sum=0;
        inorder(root);
        return sum;
    }
}