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
    /*  0 - Leaf Node (No Need of Camera)
     1 - Parent of Leaf with camera
     2 - Being Observed by another node but doesnt have camera of own
     ==TYPE 1== (Camera Required as one is leaf)
     (0,0) - camera++ (return 1)
     (0,1) - camera++ (return 1)
     (2,0) - camera++ (return 1)
     (1,0) - camera++ (return 1)
     (0,2) - camera++ (return 1
     TYPE 2 - (One of the nodes have a camera) {return 2}
     (2,1) - return 2
     (1,2) - return 2
     (1,1) - return 2
     TYPE 3 - 
     (2,2) - Both Nodes being observed but cannot observe the current root, so root is virtually a leaf ndoe
     return 0;

     YT LINK = https://www.youtube.com/watch?v=5iLSl8fNIHQ
     */
    int cameras = 0;
    public int post(TreeNode root){
        if(root==null){
            return 2;
        }

        int l = post(root.left);
        int r = post(root.right);

        if(l==0 || r==0){
            cameras++;
            return 1;
        }else if(l==1 || r==1){
            return 2;
        }else{
            return 0;
        }
    }
    public int minCameraCover(TreeNode root) {
        cameras = 0;
        int val = post(root);

        if(val==0){
            cameras++;
        }
        return cameras;
    }
}