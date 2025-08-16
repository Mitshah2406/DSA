class Solution {
    public int reverse(int x) {
        /**
        MAX = 2147483647 (2^31-1)
        MIN = -2147483648 (-2^31)
         */
        int res = 0;
        while (x != 0) {
            int digit = x % 10; // fetch last digit
            x = x / 10; // prune the number

            if (res > (Integer.MAX_VALUE / 10) ||
             (res == (Integer.MAX_VALUE / 10) && digit >= (Integer.MAX_VALUE % 10))) {
                // check if res is already max           OR
                // it value of res is 214748364 and current digit is greater than last digit of INTEGER.MAX_VALUE, due to which by adding the int range will overflow
                return 0;
            }

             if (res < (Integer.MIN_VALUE/10) || (res == (Integer.MIN_VALUE / 10) && digit <= (Integer.MIN_VALUE % 10))) {
                // check if res is already min value OR
                // it value of res is -214748364 and current digit is less than last digit of INTEGER.MIN_VALUE, due to which by adding the int range will overflow
         return 0;
            }

            res = (res*10)+digit; // shift the number by tens place and add current digit
        }

        return res;
    }
}
