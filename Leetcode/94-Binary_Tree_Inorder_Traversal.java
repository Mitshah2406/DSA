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
    public List<Integer> inorderTraversal(TreeNode root) {
            TreeNode curr = root;
            List<Integer> arr = new ArrayList();
            while(curr!=null){
                if(curr.left==null){
                    // print root and go right
                    arr.add(curr.val);
                    curr = curr.right;
                }else{
                    // take left in new pointer
                    TreeNode currp1 = curr.left;
                    // go towards the end in left branch of curr i.e right branch of currp1
                    while(currp1.right!=null && currp1.right!=curr){
                        currp1 = currp1.right;
                    }
                    // if currp1.right is null make a conenction to curr and then proceed curr to left
                    if(currp1.right==null){
                        currp1.right = curr;
                        curr = curr.left;
                    }
                    else if(currp1.right==curr){
                        // else print curr and remove conenction proceed to right of curr
                        arr.add(curr.val);
                        currp1.right = null;
                        curr = curr.right;
                    }
                }
            }

            return arr;
    }
}