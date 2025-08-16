class Solution {
    private static int linearGcd(int a, int b){
        if(a==0){
            return b;
        }
        
        if(a>b){
            return linearGcd(a-b,b);
        }
        return linearGcd(b-a, a);
    }
    
    private static int optimalGcd(int a, int b){
        if(a==0){
            // a will always become zero at somepoint, because we are doing mod in first parameter ond passing down in recursion
            return b;
        }
        
        if(a>b){
            return optimalGcd(a%b,b);
        }
        return optimalGcd(b%a, a);
    }
    public static int gcd(int a, int b) {
        /*
        GCD means Greatest Common Divisor
        gcd(15,20) = 1,5 (5 is ans)
        gcd(6,36) = 1,2,3,6 = (6 is ans)
        */
        
        // // 1. O(min(a,b)) approach
        // int ans = 0;
        // // basic math, min of a,b can be the maximum number which could divide both numbers
        // for(int i=1;i<=Math.min(a,b);i++){
        //     if(a%i==0 && b%i==0){
        //         ans = i;
        //     }
        // }
        
        // return ans;
        
        
        // 2. Euclidean Algo approach
        /*
        gcd(a,b) = gcd(a-b,b)
        gcd(52,10) = gcd(42,10), gcd(32,10) = gcd(22,10) = gcd(12,10) = gcd(2,10)=>gcd(10,2), gcd(8,2) = 
        gcd(6,2) = gcd(6,2) = gcd(4,2) = gcd(2,2) = gcd(0,2) [hence we reach 0, hence other non zero number is gcd]
        */

        // This will still take up linear time, as we are subtracting only..
        // return linearGcd(a,b);
        
        
        // 3. Optimized Logarithmic Euclidean Algo approach O(log phi min(a,b))
        /*
        gcd(a,b) = gcd(a-b,b)
        gcd(52,10) = gcd(42,10), gcd(32,10) = gcd(22,10) = gcd(12,10) = gcd(2,10)=>gcd(10,2), gcd(8,2) = 
        gcd(6,2) = gcd(6,2) = gcd(4,2) = gcd(2,2) = gcd(0,2) [hence we reach 0, hence other non zero number is gcd]
        
        Here, if we carefully see gcd for 52 & 10,we subtarct 10 five times we are just doing modulus, 
        52%10 = 2, by doiing mod we reach exactly there only becuase it is basically division only
        
        gcd(2,10) after 5 steps or 1 mod = gcd(a,b) = gcd(a%b,b) or gcd(b%a,a) (whichever is maximum)
        */

        // This will still take up linear time, as we are subtracting only..
        return optimalGcd(a,b);
    }
}
