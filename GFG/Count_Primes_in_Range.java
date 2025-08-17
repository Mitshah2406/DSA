// User function Template for Java

class Solution {
    /*
    Just do sieve and count truthy values in arr
    Time - O(RloglogR)
    Space = O(R)
    */
    private void sieve(boolean primes[], int n){
        primes[0] = primes[1] = false;
        
        for(int i=2;i*i<=n;i++){
            if(primes[i]){
                for(int j=i*i;j<=n;j+=i){
                    primes[j] = false;
                }
            }
        }
    }
    int countPrimes(int L, int R) {
        // code here
        boolean primes[] = new boolean[R+1];
        Arrays.fill(primes,true);
        sieve(primes, R);
        
        int cnt = 0;
        for(int i=L;i<=R;i++){
            if(primes[i]) cnt++;
        }
        
        return cnt;
    }
};
