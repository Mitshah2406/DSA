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
class Pair {
    TreeNode n;
    int row;
    int col;

    public Pair(TreeNode n, int row, int col) {
        this.n = n;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> arr = new ArrayList();

        HashMap<Integer, List<Pair>> hm = new HashMap();
        Queue<Pair> q = new LinkedList();

        HashSet<int[]> hs = new HashSet();

        q.add(new Pair(root, 0, 0));
        hs.add(new int[] { 0, 0 });
        int level = 0;

        while (q.size() != 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) { // row is same jo bhi queue me add honge
                Pair rem = q.poll();
                TreeNode node = rem.n;
                int r = rem.row;
                int c = rem.col;

                List<Pair> temp = hm.getOrDefault(c, new ArrayList());
                temp.add(rem);
                hm.put(c, temp);
                if (node.left != null) {
                    q.add(new Pair(node.left, r + 1, c - 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, r + 1, c + 1));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : hm.keySet()) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        Comparator comp = new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                int ans = a.row-b.row;
                if(ans==0){
                    return a.n.val-b.n.val;  
                }
                return ans;
            }
        };
        for (int i = min; i <= max; i++) {
            List<Pair> t = hm.get(i);
            Collections.sort(t, comp);
            List<Integer> t1 = new ArrayList();
            for(int j=0;j<t.size();j++){
                t1.add(t.get(j).n.val);
            }
            arr.add(t1);
        }

        return arr;
    }
}