class Solution {
    public boolean checkBit(int n, int k) {
        if ((n & (1 << k)) == 0) {
            return false;
        }
        return true;
    }

    // public int subsetXORSum(int[] nums) {
    //     int n = nums.length;
    //     int sum = 0;
    //     int total = 1 << n;
    //     for (int i = 1; i < total; i++) {
    //         int xor = 0;
    //         for (int j = 0; j < n; j++) {
    //             if (checkBit(i, j)) {
    //                 xor = xor^nums[j];
    //             }
    //         }
    //         sum+=xor;
    //     }
    //     return sum;
    // }
    public int subsetXORSum(int[] nums) {
    int result = 0;
    
    // Bitwise OR all numbers to get bits that appear in any number
    for (int num : nums) {
        result |= num;
    }
    System.out.println(result);
    // Each bit contributes 2^(n-1) to the final sum
    return result * (1 << (nums.length-1));
}
}
