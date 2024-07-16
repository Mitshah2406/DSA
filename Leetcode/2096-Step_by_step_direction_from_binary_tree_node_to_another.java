// Medium

// You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

// Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

// 'L' means to go from a node to its left child node.
// 'R' means to go from a node to its right child node.
// 'U' means to go from a node to its parent node.
// Return the step-by-step directions of the shortest path from node s to node t.

 

// Example 1:


// Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
// Output: "UURL"
// Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
// Example 2:


// Input: root = [2,1], startValue = 2, destValue = 1
// Output: "L"
// Explanation: The shortest path is: 2 → 1.
 

// Constraints:

// The number of nodes in the tree is n.
// 2 <= n <= 105
// 1 <= Node.val <= n
// All the values in the tree are unique.
// 1 <= startValue, destValue <= n
// startValue != destValue


//Link --> https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/
class Solution {
    private TreeNode lca(TreeNode root, int p, int q) {
        // getting the lowest common ancestor of both soruce and dest
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        return root;
    }

    private boolean findPath(TreeNode root, StringBuilder path, int target) {
        // finding path for each i.e source and dest from lca as root
        if (root == null)
            return false;
        if (root.val == target)
            return true;
        // going left
        path.append("L");
        if (findPath(root.left, path, target)) {
            // if target got return true
            return true;
        }
        // otherwise remove "L" direction
        path.setLength(path.length() - 1);
        // going right
        path.append("R");
        if (findPath(root.right, path, target)) {
            // otherwise remove "R" direction
            return true;
        }
        // otherwise remove "R" direction
        path.setLength(path.length() - 1);

        // if node is not in curr subtree i.e root ke left subtree and right subtree
        // then return false
        return false;

    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        // finding the lca for src,dest
        TreeNode ca = lca(root, startValue, destValue);
        StringBuilder path = new StringBuilder();
        if (findPath(ca, path, startValue)) {
            // remove the length of path that we got for source as "L" and add respective
            // length of "U"
            int n = path.length();
            // removing length of L's recieved
            path.setLength(n - n);
            for (int i = 0; i < n; i++) {
                // adding that much length of U coz we always go "U" from src
                path.append("U");
            }
        }

        if (findPath(ca, path, destValue)) {
            // simply return
            return path.toString();
        }
        return path.toString();
    }
}


// TC - O(n)
// SC - O(n)