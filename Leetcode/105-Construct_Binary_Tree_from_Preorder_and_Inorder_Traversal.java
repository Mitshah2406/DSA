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
    public TreeNode construct(int pre[], int ps, int pe, int in[], int is, int ie, HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie) {
            return null;
        }
        int inRootIdx = -1;

        // this loop could be optimized
        // for (int i = is; i <= ie; i++) {
        // if (in[i] == pre[ps]) {
        // inRootIdx = i;
        // break;
        // }
        // }
        inRootIdx = hm.get(pre[ps]);
        int elems = inRootIdx - is;

        TreeNode root = new TreeNode(pre[ps]);

        root.left = construct(pre, ps + 1, ps + elems, in, is, inRootIdx - 1, hm);
        root.right = construct(pre, ps + elems + 1, pe, in, inRootIdx + 1, ie, hm);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < n; i++) {
            hm.put(inorder[i], i);
        }
        return construct(preorder, 0, n - 1, inorder, 0, n - 1, hm);
    }
}