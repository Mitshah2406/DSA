class Solution {
    static boolean isPrime(int n) {
        // BRUTE FORCE would be O(n)
        
        // Optimal is O(root(N))
        // Prime Number is a number which has exactly two factors (1 & itself)
        int cnt = 0;
        for(int i=1;i*i<=n;i++){
            if(cnt>2) return false;
            if(n%i==0){
                cnt++;
                if(i!=n/i) cnt++;
            }
        }
        return cnt==2;
    }
}
