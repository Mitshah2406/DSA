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
    public TreeNode build(int arr[], int st, int end){
        if(st>end){
            return null;
        }

        // find right part
        int idx;
        for(idx=st;idx<=end;idx++){
            if(arr[idx]>arr[st]){
                break;
            }
        }

        TreeNode root = new TreeNode(arr[st]);
        root.left = build(arr, st+1, idx-1);
        root.right = build(arr, idx, end);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length-1);
    }
}