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
    public static TreeNode solve(int val, HashMap<Integer, List<int[]>> hm){
        TreeNode root = new TreeNode(val);

        for(int[] c : hm.getOrDefault(val, new ArrayList<>())){
            if(c[1]==1){
                root.left = solve(c[0], hm);
            }else{
                root.right = solve(c[0], hm);
            }
        }
        return root;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> rootHS = new HashSet<>();
        HashSet<Integer> childs = new HashSet<>();
        HashMap<Integer, List<int[]>> hm = new HashMap();

        for(int d[]: descriptions){
            int parent = d[0];
            int child = d[1];
            int direction = d[2];

            childs.add(child);
            rootHS.remove(child);
            if(!childs.contains(parent)){
                rootHS.add(parent);
            }

            List<int[]> childrens = hm.getOrDefault(parent, new ArrayList<>());

            childrens.add(new int[]{child, direction});
            hm.put(parent, childrens);
        }

        return solve(rootHS.iterator().next(), hm);
    }
}