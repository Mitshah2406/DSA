class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int op = 0;
        int i = 0;
        while (i < n) {
            HashSet<Integer> hs = new HashSet();
            boolean allDistinct = true;
            for (int j = i; j < n; j++) {
                if (hs.contains(nums[j])) {
                    i += 3;
                    op++;
                    allDistinct = false;
                    break;
                } else {
                    hs.add(nums[j]);
                }
            }
            if (allDistinct)
                break;
        }

        return op;
    }
}