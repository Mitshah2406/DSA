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
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> ans = new ArrayList();
    //     if(root==null) return ans;

    //     Queue<TreeNode> q = new LinkedList();

    //     q.add(root);

    //     while(q.size()>0){
    //         int n = q.size();
    //         List<Integer> temp = new ArrayList();
    //         for(int i=1;i<=n;i++){
    //             TreeNode rem = q.remove();
    //             temp.add(rem.val);

    //             if(rem.left!=null){
    //                 q.add(rem.left);
    //             }
    //             if(rem.right!=null){
    //                 q.add(rem.right);
    //             }
    //         }
    //         ans.add(temp);
    //     }
    //     return ans;
    // }
    public List<List<Integer>> levelOrder(TreeNode root) {    
        List<List<Integer>> ans = new ArrayList();

        int level=0;
        compute(root, ans, level);

        return ans;
    }

    private void compute(TreeNode curr, List<List<Integer>> ans, int level){
        if(curr==null) return;

        if(ans.size()==level){
            ans.add(new ArrayList());
        }

        ans.get(level).add(curr.val);

        compute(curr.left, ans, level+1);
        compute(curr.right, ans, level+1);
    }
}