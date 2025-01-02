// /**
// *Definition for a binary tree node.*
// public class TreeNode {
//     *
//     int val;*
//     TreeNode left;*
//     TreeNode right;*

//     TreeNode() {
//     }*

//     TreeNode(int val) {
//         this.val = val;
//     }*

//    TreeNode(int val, TreeNode left, TreeNode right) {
//  * this.val = val;
//  * this.left = left;
//  * this.right = right;
//  * }*
// }*/

class Solution {
    // private void preorder(TreeNode root, ArrayList<Integer> nodes) {
    //     if (root == null) {
    //         nodes.add(Integer.MIN_VALUE);
    //         return;
    //     }

    //     nodes.add(root.val);
    //     preorder(root.left, nodes);
    //     preorder(root.right, nodes);
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
        // if u add some special values for nulls then it can work
        // ArrayList<Integer> pNodes = new ArrayList();
        // ArrayList<Integer> qNodes = new ArrayList();
        // preorder(p, pNodes);
        // preorder(q, qNodes);

        // return pNodes.equals(qNodes);

        // Other Approach

        return isSame(p, q);
    }
}
