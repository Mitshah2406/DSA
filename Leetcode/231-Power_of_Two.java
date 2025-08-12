class Solution {
    public boolean isPowerOfTwo(int n) {
        // log base 2 for n = log base e for n / log base e for 2

        // Doesnt Work (Overflow issue)
        // double ans = (double) Math.log(n) / (double) Math.log(2);

        // return ans==Math.round(ans);

        // Brute

        // int ans = 1;
        // int it = 0;
        // while(ans<n && it<32){
        //     ans = 1<<it;
        //     it++;
        // }
        // return ans==n;

        // Better
        // Any number which has only one bit set, by doing minus 1 makes that bit 0, and previous bits as 1
        // so if we do logical AND, then we will get all zeros, in any other case this wont work

        // 10000 & (16-1)[01111] = 00000 [power of two]
        // 11000 & (24-1)[10111] = 10000 [not a power of two]
        // Still this solution isnt a optimal soln, as we have n as 32 bits, it will work till 64 but what after it, we will need some kind of wrapper class, making it theoritically a logn solution
        // return n>0 && (n&n-1)==0; 

        // Best
        // any power of two could be divide the maximum power of two mentioned in the constraint
        // so if n is even more than 64, this is a true O(1) soln
        return n>0 && ((1<<30) % n) == 0;
    }
}

// 16 = 2^x

// b = a^c

// log`a (b) = c