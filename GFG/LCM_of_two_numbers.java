class Solution {
    private int gcd(int a, int b){
        if(a==0){
            return b;
        }
        if(a>b){
            return gcd(a%b,b);
        }else{
            return gcd(b%a,a);
        }
    }
    public int lcm(int a, int b) {
        // code here
        return (a*b)/gcd(a,b);
    }
}

// 12 = 2 x 2 x 3 = 2^2 x 3^1
// 18 = 2 x 3 x 3 = 2^1 x 3^2

// gcd(12,18) = gcd(18,12) = gcd(6,12) = gcd(12,6) = gcd(0,6) = 6

// GCD takes min exponents for common factors = 2^1 x 3^1 = 6
// LCM takes max exponents for common factors = 2^2 x 3^2 = 36

// So gcd = 6
// if we combine the prime factors i.e multiply them
// we get (12x18) = 216(ans)
// we can say that gcd is also part of ans, and lcm too
// therefore, gcd x lcm = ans
// hence, a x b
//      --------
//.      gcd(a,b)
// Time Complexity O(log(min(a,b)))
// Space Complexity O(log(min(a,b)))
