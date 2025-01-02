/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int x = countNodes(root.left);
        int y = countNodes(root.right);
        return x+y+1;
    }
    public static int getSize(Node node) {
        return countNodes(node);
    }
}
        
