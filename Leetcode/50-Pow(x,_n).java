class Solution {

    public double myPow(double x, int n) {
        double ans = 1.0;
        long m = n;
        if (m < 0) {
            // if power is negative, convert to +ve
            m = -1 * m;
        }
        // if power is odd, minus one power put 1 x in ans
        // even , rewrite as (x^2)^(n/2) basically if both 2 cancels out, we get the same thing
        // so we x^2 adn outside power reduces by /2 that is logn complexity
        while (m > 0) {
            if (m % 2 == 1) {
                m -= 1;
                ans *= x;
            } else {
                m = m / 2;
                x = x * x;
            }
        }

        if (n < 0) {
            // 5^-2 can be written as 1/5^2
            return 1.0 / ans;
        }
        return ans;
    }
}