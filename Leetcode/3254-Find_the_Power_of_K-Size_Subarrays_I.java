class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int n = nums.length;
        int res[] = new int[n - k + 1];
        int w = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                res[w] = -1;
                break;
            }

        }
        if (res[w] == 0) {
            res[w] = nums[k - 1];
        }
        w++;

        for (int i = k; i < n; i++) {
            // Remove i-k and add i

            for (int j = i - k + 1; j < i; j++) {
                if ((nums[j] + 1 != nums[j + 1])) {
                    res[w] = -1;
                    break;
                }
            }
            if (res[w] == 0) {
                res[w] = nums[i];
            }
            w++;
        }
        return res;
    }
}