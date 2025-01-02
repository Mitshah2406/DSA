/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // private void inorder(TreeNode root, ArrayList<Integer> nodes){
    // if(root==null){
    // return;
    // }

    // inorder(root.left, nodes);
    // nodes.add(root.val);
    // inorder(root.right, nodes);
    // }

    private boolean isSame(TreeNode p, TreeNode q) {
        // check if both are null first
        if (p == null && q == null) {
            return true;
        }
        // check if one of them is null
        if (p == null || q == null) {
            return false;
        }
        // check for values
        if (p.val != q.val) {
            return false;
        }
        boolean l = isSame(p.left, q.left);
        boolean r = isSame(p.right, q.right);
        // return logical and of the result both subtrees gave
        return l && r;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Brute Force (doesnt work if count of nodes is same and also if all nodes have
        // same value)

        // ArrayList<Integer> pNodes = new ArrayList();
        // ArrayList<Integer> qNodes = new ArrayList();
        // inorder(p, pNodes);
        // inorder(q, qNodes);

        // int pN = pNodes.size();
        // int qN = qNodes.size();

        // if(pN!=qN){
        // return false;
        // }else{
        // for(int i=0;i<pN;i++){
        // if(pNodes.get(i)!=qNodes.get(i)){
        // return false;
        // }
        // }
        // }

        // return true;

        // Other Approach

        return isSame(p, q);
    }
}