/*node class of the binary ssearch tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution
{
    public static int traverse(Node root){
        if(root==null){
            return 0;
        }
        int ans = 0;
        int x = traverse(root.left);
        int y = traverse(root.right);
        
        if(root.left==null && root.right==null){
            ans+=root.data;
        }
        
        return ans+x+y;
    }
    public static int sumOfLeafNodes(Node root)
    {
        return traverse(root);
    }
}
