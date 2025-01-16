/*class Node of the binary tree
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
class Solution {

    public boolean preorder(Node root, int target, ArrayList<Integer> arr){
        if(root==null){
            return false;
        }
        if(root.data==target){
            return true;
        }
        boolean left = preorder(root.left, target, arr);
        boolean right = preorder(root.right, target, arr);
        if(left||right){
            arr.add(root.data);
        }
        return left||right;
    }
    public ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> arr = new ArrayList();
        preorder(root, target, arr);
        return arr;
    }
}