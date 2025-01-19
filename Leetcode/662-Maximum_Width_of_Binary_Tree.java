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
    /*
    0 based indexing 
        left node is. = 2*i+1
        right node is. = 2*i+2


    1 based indexing 
        left node is. = 2*i
        right node is. = 2*i+1


    NOTE = These formulas are generated from segment trees as they are used frequnetly there. So learn it..
    Striver video = https://www.youtube.com/watch?v=ZbybYvcVLks
     */
    class Pair{
        int i;
        TreeNode node;
        public Pair(int i, TreeNode node){
            this.i=i;
            this.node= node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(0, root));
        int maxNodes = -1;

        while(q.size()!=0){
            int n = q.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                Pair rem = q.poll();
                TreeNode node = rem.node;
                int i = rem.i;
                min = Math.min(min,i);
                max = Math.max(max,i);
                if(node.left!=null){
                    q.add(new Pair(2*i+1 ,node.left));
                }
                if(node.right!=null){
                    q.add(new Pair(2*i+2 ,node.right));
                }
            }
            maxNodes = Math.max(maxNodes, max-min+1);
        }
        return maxNodes;
    }
}