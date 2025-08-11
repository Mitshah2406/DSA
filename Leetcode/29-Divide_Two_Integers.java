class Solution {
    public int divide(int dividend, int divisor) {
        /**
            BRUTE FORCE
            Time Complexity is O(dividend) if in worst case divisor is 1
            Space Complexity = O(1)
        
         */
        // int cut = 0;
        // int c = 0;
        // boolean sign = false;
        // if (dividend < 0 && divisor >= 0)
        //     sign = true;
        // if (dividend >= 0 && divisor < 0)
        //     sign = true;
        // dividend = Math.abs(dividend);
        // divisor = Math.abs(divisor);
        // while (cut + divisor <= dividend) {
        //     cut += divisor;
        //     c++;
        // }
        // return sign ? (-1 * c) : c;
       /**
         * Optimal Approach (Bit Manipulation + Doubling)
         * 
         * Idea:
         *  - Instead of subtracting the divisor from the dividend one by one (O(dividend) time),
         *    we speed up the process by subtracting the largest possible multiple of divisor 
         *    in each step.
         *  - This is done by representing the quotient in powers of two (shifting the divisor left).
         *  - For example: 
         *      dividend = 43, divisor = 3
         *      Step 1: largest multiple <= 43 is 3 << 3 = 24 -> quotient += 8, dividend = 19
         *      Step 2: largest multiple <= 19 is 3 << 2 = 12 -> quotient += 4, dividend = 7
         *      Step 3: largest multiple <= 7 is 3 << 1 = 6  -> quotient += 2, dividend = 1
         *      Total quotient = 8 + 4 + 2 = 14
         * 
         * Time Complexity:
         *  - Outer loop runs O(log(dividend/divisor)) times
         *  - Inner loop (shifting) runs O(log(dividend/divisor)) in each iteration
         *  - Overall: O(log^2(dividend/divisor)), which is much faster than O(dividend)
         * 
         * Space Complexity:
         *  - O(1) extra space (only variables used, no extra data structures)
         * 
         * Special Considerations:
         *  - Handle overflow for Integer.MIN_VALUE / -1 case (returns Integer.MAX_VALUE)
         *  - Use long for intermediate calculations to avoid overflow during shifts
         *  - Carefully determine the sign of the result
         */

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // overflow case
        }

        int c = 0;
        boolean sign = false;
        if (dividend < 0 && divisor >= 0) sign = true;
        if (dividend >= 0 && divisor < 0) sign = true;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        while (a >= b) {
            long cut = 0;

            // Find largest shift such that (b << (cut+1)) <= a
            while ((b << (cut + 1)) <= a) {
                cut++;
            }

            a -= (b << cut);      // Subtract that multiple from dividend
            c += (1 << cut);      // Add corresponding power-of-two to quotient
        }

        return sign ? (-1 * c) : c;
    }
}