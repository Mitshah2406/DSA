class Solution {
    public int minSwaps(int[] nums) {
        int ws = 0;
        for (int num : nums) {
            ws+=num;
        }

        int currZeros = 0;

        for (int i = 0; i < ws; i++) {
            if (nums[i] == 0)
                currZeros++;
        }

        int minZeros = currZeros;

        int start = 0;
        int end = ws-1;
        int n = nums.length;
        while(start<n){
            if(nums[start]==0){
                currZeros--;
            }
            start++;
            end++;
            if(nums[end%n]==0){
                currZeros++;
            }

            minZeros = Math.min(minZeros, currZeros);
        }

        return minZeros;
    }
}