// User function Template for Java

class Solution {
    private static int xor(int n){
        if(n%4==1){
            return 1;
        }else if(n%4==2){
            return n+1;
        }else if(n%4==3){
            return 0;
        }else{
            return n;
        }
    }
    public static int findXOR(int l, int r) {
        /*
        Here N means XOR OF 1..N
        N=1     1
        N=2     3
        N=3     0
        N=4     4
        
        N=5     1
        N=6     7
        N=7     0
        N=8     8
        
        N=9     1
        .
        .
        
        Generalizing, 
        N%4==1; `1` 
        N%4==2; 'N+1'
        N%4==3; `0`
        N%4==0; `N`
        */
        
        // XOR OF L..R = XOR OF L-1 (^) XOR OF R
        // L = 4, R = 7
        // (1^2^3) ^ (1^2^3^4^5^6^7) = (4^5^6^7) as 1,2,3 gets cut
        return xor(l-1) ^ xor(r);
    }
}
