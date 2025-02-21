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
class FindElements {
    public void buildTree(TreeNode root, HashSet<Integer> hs) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            hs.add(root.left.val);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            hs.add(root.right.val);
        }
        buildTree(root.left, hs);
        buildTree(root.right, hs);
    }

    HashSet<Integer> hs;

    public FindElements(TreeNode root) {
        hs = new HashSet();
        root.val = 0;
        hs.add(0);
        buildTree(root, hs);
    }

    public boolean find(int target) {
        return hs.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */