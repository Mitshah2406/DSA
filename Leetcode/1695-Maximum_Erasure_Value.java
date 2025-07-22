class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int ans = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hm = new HashMap();
        int p[] = new int[n];
        p[0] = nums[0];
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] + nums[i];
        }
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(nums[i])) {
                sum += nums[i];
                hm.put(nums[i], i);
            } else {
                int idx = hm.get(nums[i]);
                int deductSum = 0;
                if (idx >= start) {
                    if (start == 0) {
                        deductSum = p[idx];
                    } else {
                        deductSum = p[idx] - p[start - 1];
                    }
                    start = idx + 1;
                    sum -= deductSum;
                }
                sum += nums[i];
                hm.put(nums[i],i);
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}