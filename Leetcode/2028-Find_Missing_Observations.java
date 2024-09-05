class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int rollsSum = 0;
        int m = 0;
        for (int r : rolls) {
            rollsSum += r;
            m++;
        }
        int remainingRollsSum = (mean * (n + m)) - rollsSum;

        int remainder = remainingRollsSum % n;
        int divisor = remainingRollsSum / n;

        // base cases
        if (divisor > 6 || divisor == 0 || remainingRollsSum < 0) {
            return new int[] {};
        }
        int ans[] = new int[n];

        // fill it first with divisor
        Arrays.fill(ans, divisor);

        // distribute the remainder accross arr such that no arr[i]>6 and remainder==0
        for (int i = 0; i < n && remainder > 0; i++) {
            int remain = 6 - ans[i];
            if (remain > 0 && remainder - remain >= 0) {
                ans[i] += remain;
                remainder -= (remain);
            } else {
                if (remainder > 0 && remainder < remain) {
                    ans[i] += remainder;
                    remainder = 0;
                }
            }
        }

        // if still remainder is left then return empty arr
        if (remainder != 0) {
            return new int[] {};
        }
        return ans;
    }
}
