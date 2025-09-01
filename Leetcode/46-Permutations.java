class Solution {
    private void solve(int i, int n, int nums[], ArrayList<Integer> curr, List<List<Integer>> ans, boolean used[]) {
        if (curr.size() == n) {
            ans.add(new ArrayList<>(curr));
        }
        for (int q = 0; q < n; q++) {
            if (!used[q]) {
                curr.add(nums[q]);
                used[q] = true;
                solve(q, n, nums, curr, ans, used);
                used[q] = false;
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean used[] = new boolean[n];
        solve(0, n, nums, new ArrayList<Integer>(), ans, used);
        return ans;
    }
}
