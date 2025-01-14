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
    public static void preorder(Node root,ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> temp){
        if(root==null){
            return;
        }
        
        temp.add(root.data);
        if(root.left==null && root.right==null){
            
            paths.add(new ArrayList(temp));
        }
        preorder(root.left, paths,temp);
        preorder(root.right, paths,temp);
        temp.remove(temp.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // do preorder and just add all paths which reach to leaf
        ArrayList<ArrayList<Integer>> paths = new ArrayList();
        ArrayList<Integer> temp = new ArrayList();
        
        preorder(root, paths, temp);
        
        return paths;
    }
}
