class Solution {
    private void back(int idx, List<List<Integer>> ans, int arr[], int target, ArrayList<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && (arr[i] == arr[i - 1]))
                continue;
            if (arr[i] > target)
                break;

            ds.add(arr[i]);
            back(i + 1, ans, arr, target - arr[i], ds);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(candidates);
        back(0, ans, candidates, target, new ArrayList<Integer>());
        return ans;
    }
}