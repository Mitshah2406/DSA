/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void inorder(List<Integer> arr, TreeNode root){
        if(root==null){
            return;
        }
        inorder(arr, root.left);
        arr.add(root.val);
        inorder(arr, root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList();
        // inorder(arr, root);
        // morris (inorder - left,node,right)

        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                // if left is null process node and go right
                arr.add(curr.val);
                curr = curr.right;
            }else{
                // if left is non null
                TreeNode currp1 = curr.left; 

                while(currp1.right!=null && currp1.right!=curr){
                    currp1 = currp1.right;
                }

                if(currp1.right==null){
                    // if first time then establish link and then move curr to left
                    currp1.right = curr;
                    curr = curr.left;
                }else{
                    // if second time print node, destroy link, move to right

                    currp1.right = null;
                    arr.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return arr;
    }
}