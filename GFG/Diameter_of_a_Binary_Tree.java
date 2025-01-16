// User function Template for Java

/*class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class Solution {
    // Function to return the diameter of a Binary Tree.
      static int longest = 0;
    public int findHeight(Node root){
        if(root==null){
            return 0;
        }

        int x = findHeight(root.left);
        int y = findHeight(root.right);
        longest = Math.max(longest, (x+y+1)); // basically counting nodes only
        return Math.max(x,y)+1;
    }
    int diameter(Node root) {
         longest = 0;
        findHeight(root);
        return longest-1; // so idher se minus 1
    }
}
