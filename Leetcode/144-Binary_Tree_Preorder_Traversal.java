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
    public List<Integer> preorderTraversal(TreeNode root) {
        //Morris Preorder
        TreeNode curr = root;
        List<Integer> arr = new ArrayList();
        while(curr!=null){
            if(curr.left==null){
                arr.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode currp1 = curr.left;

                while(currp1.right!=null && currp1.right!=curr){
                    currp1 = currp1.right;
                }

                if(currp1.right==null){
                    currp1.right = curr;
                    arr.add(curr.val);
                    curr = curr.left;
                }else if(currp1.right==curr){
                    currp1.right = null;
                    curr = curr.right;
                }
            }
        }
        return arr;
    }
}