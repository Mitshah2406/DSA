
class Solution {
    
    // Euclidean algorithm to compute GCD of two numbers
    public int gcd(int a, int b){
        if(a==0){
            return b;
        }
        int rem = b%a;
        return gcd(rem,a);
    }

    // LCM of two numbers using: LCM(a, b) = (a * b) / GCD(a, b)
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // LCM of three numbers: LCM(a, b, c) = LCM(LCM(a, b), c)
    public int lcm3(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    }

    // Function to compute the maximum possible LCM of any three integers ≤ n
    int lcmTriplets(int n) {
        // Base case: for n <= 2, the maximum LCM is just n
        if (n <= 2) return n;

        /*
         * Key Insight:
         * - LCM is highest when numbers are large and co-prime.
         * - For odd n: (n, n-1, n-2) are nearly co-prime → maximum LCM.
         * - For even n: (n, n-1, n-2) includes multiple even numbers → lower LCM.
         *   So we check two better combinations:
         *     - (n, n-1, n-3): skips extra even factors
         *     - (n-1, n-2, n-3): also generally co-prime
         */
        if (n % 2 != 0) {
            return lcm3(n, n - 1, n - 2);
        } else {
            int option1 = lcm3(n, n - 1, n - 3);
            int option2 = lcm3(n - 1, n - 2, n - 3);
            return Math.max(option1, option2);
        }
    }
}
