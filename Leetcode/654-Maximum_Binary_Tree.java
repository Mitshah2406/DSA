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
    public TreeNode buildTree(int arr[], int st, int end){
        if(st>end){
            return null;
        }

        int max = -1;
        int maxIdx = -1;

        for(int i=st;i<=end;i++){
            if(max<arr[i]){
                max = arr[i];
                maxIdx = i;
            }
        }

        TreeNode root = new TreeNode(max);

        root.left = buildTree(arr, st, maxIdx-1);
        root.right = buildTree(arr, maxIdx+1, end);

        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
}