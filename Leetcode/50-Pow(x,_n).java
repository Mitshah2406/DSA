class Solution {
    public double myPow(double x, int n) {
        // odd power subtract one, and multiply num to ans
        // even power 2^20 = (2^2)20/2 (cut 2 and 2 it is same number)
        // = 4^10 (so N which was 20 , now N/2 = 10)
        // and X = 2 is X*X;
        double ans = 1.0;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        while (N > 0) {
            if (N % 2 == 1) {
                ans = ans * x;
                N -= 1;
            } else {
                N /= 2;
                x = x * x;
            }
        }
        return ans;
    }
}