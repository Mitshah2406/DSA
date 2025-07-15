/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // static TreeNode ans = null;

    // public boolean[] postorder(TreeNode root, TreeNode p, TreeNode q) {
    // if (root == null) {
    // return new boolean[] { false, false };
    // }

    // boolean l[] = postorder(root.left, p, q);
    // boolean r[] = postorder(root.right, p, q);

    // boolean res[] = new boolean[2];
    // if (root == p) {
    // res[0] = true;
    // } else if (root == q) {
    // res[1] = true;
    // }
    // res[0] = res[0] || l[0] || r[0];
    // res[1] = res[1] || l[1] || r[1];
    // if (res[0] && res[1] == true) {
    // ans = root;
    // return new boolean[] { false, false };
    // }
    // return res;

    // }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // ans = null;
    // postorder(root, p, q);
    // return ans;
    // }


    // optimal using less space
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
   // Base case: if we've reached a null node, there's nothing to find here
   if (root == null) {
       return root;
   }
   
   // Base case: if current node is one of our target nodes,
   // we've found at least one of them, so return this node
   if (root == p || root == q) {
       return root;
   }
   
   // Recursively search for p and q in the left subtree
   // This will return:
   // - null if neither p nor q exists in left subtree
   // - the LCA if both p and q exist in left subtree
   // - p or q if only one of them exists in left subtree
   TreeNode l = findLCA(root.left, p, q);
   
   // Recursively search for p and q in the right subtree
   // Same return logic as left subtree search
   TreeNode r = findLCA(root.right, p, q);
   
   // Critical decision point: if both left and right searches returned non-null,
   // it means p and q are in different subtrees (one in left, one in right)
   // Therefore, the current root is their lowest common ancestor
   if (l != null && r != null) {
       return root;
   }
   
   // If only left subtree returned something, then:
   // - Either both p and q are in left subtree (and l is their LCA)
   // - Or only one of p/q is in left subtree (and l is that node)
   // In both cases, we return l as it contains our answer
   if (l != null) {
       return l;
   }
   
   // If only right subtree returned something, same logic as above
   // but for the right subtree
   if (r != null) {
       return r;
   }
   
   // If both left and right returned null, neither p nor q exists
   // in this subtree, so return null
   return null;
}

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
   return findLCA(root, p, q);
}
}
