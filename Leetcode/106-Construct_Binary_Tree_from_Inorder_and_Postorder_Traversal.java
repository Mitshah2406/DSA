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
    public TreeNode construct(int post[], int ps, int pe, int in[], int is, int ie, HashMap<Integer, Integer> hm) {
        if (is > ie || ps > pe) {
            return null;
        }
        int rootIdx = -1;
        // for (int i = is; i <= ie; i++) {
        //     if (post[pe] == in[i]) {
        //         rootIdx = i;
        //         break;
        //     }
        // }
        rootIdx = hm.get(post[pe]);
        int elems = rootIdx - is;
        TreeNode root = new TreeNode(post[pe]);

        root.left = construct(post, ps, ps + elems - 1, in, is, rootIdx - 1, hm);
        root.right = construct(post, ps + elems, pe - 1, in, rootIdx + 1, ie, hm);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        // optimal using hm

        HashMap<Integer, Integer> hm = new HashMap();

        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }
        return construct(postorder, 0, n - 1, inorder, 0, n - 1, hm);
    }
}