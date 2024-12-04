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
class BSTIterator {
    // Time Complexity = O(1), Space - O(N) for next(), hasNext()
    // public void inorder(TreeNode root, Stack<Integer> st){
    // if(root==null){
    // return;
    // }
    // inorder(root.left,st);
    // st.push(root.val);
    // inorder(root.right,st);
    // return;
    // }
    // Stack<Integer> s1;
    // Stack<Integer> s2;
    // public BSTIterator(TreeNode root) {
    // s1 = new Stack();
    // s2 = new Stack();
    // inorder(root, s1);

    // while(!s1.isEmpty()){
    // s2.push(s1.pop());
    // }
    // }

    // public int next() {
    // if(!s2.isEmpty()){
    // return s2.pop();
    // }
    // return -1;
    // }

    // public boolean hasNext() {
    // if(s2.isEmpty()){
    // return false;
    // }else{
    // return true;
    // }
    // }

    // Optimal - just explore left side of stack and keep on pushing root, if called next after popping check if it has a right
    // time - O(1) and space O(h)
    public void pushAll(TreeNode root, Stack<TreeNode> st) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack();
        pushAll(root, st);
    }

    public int next() {
        TreeNode rem = st.pop();
        pushAll(rem.right,st);
        return rem.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */