class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        
        // Step 1: XOR all numbers.
        // After this step, xorr will be equal to (num1 ^ num2) 
        // because all numbers appearing twice will cancel out.
        int xorr = 0;
        for (int i : nums) {
            xorr ^= i;
        }
        // Example: nums = [1, 2, 1, 3, 2, 5]
        // After XOR of all: xorr = 3 ^ 5 = 6  (binary: 0110)

        // Step 2: Find the rightmost set bit in xorr.
        // (xorr & (xorr - 1)) clears the rightmost set bit.
        // XORing it again with xorr isolates that bit.
        long xorrM1 = (xorr & (xorr - 1)) ^ xorr;
        // Example:
        // xorr = 6 (binary 0110)
        // xorr - 1 = 5 (binary 0101)
        // xorr & (xorr - 1) = 0100
        // (xorr & (xorr - 1)) ^ xorr = 0100 ^ 0110 = 0010
        // So xorrM1 = 2 (binary 0010), i.e. the rightmost set bit.

        int b1 = 0; // Will hold the first unique number
        int b2 = 0; // Will hold the second unique number

        // Step 3: Split numbers into two groups based on xorrM1.
        // Example:
        // Grouping based on bit (0010):
        // Numbers with this bit set: 2 (0010), 2 (0010), 3 (0011)
        // Numbers without this bit: 1 (0001), 1 (0001), 5 (0101)
        // XOR in each group:
        // Group 1: 2 ^ 2 ^ 3 = 3
        // Group 2: 1 ^ 1 ^ 5 = 5
        for (int i = 0; i < n; i++) {
            if ((nums[i] & xorrM1) != 0) {
                b1 ^= nums[i]; // Group 1
            } else {
                b2 ^= nums[i]; // Group 2
            }
        }

        // Step 4: Return the two unique numbers.
        return new int[] { b1, b2 };
    }
}
