class Solution {
    private void compute(TreeNode root, ArrayList<ArrayList<Integer>> ans, int level){
        if(root==null) return;

        if(ans.size()==level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        compute(root.left, ans, level+1);
        compute(root.right, ans, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        compute(root, ans, 0);
        List<Integer> rightView = new ArrayList();
        for(int i=0;i<ans.size();i++){
            int n = ans.get(i).size();
            rightView.add(ans.get(i).get(n-1));
        }

        return rightView;
    }
}