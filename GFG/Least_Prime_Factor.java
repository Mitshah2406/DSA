// User function Template for Java
class Solution {
    public int[] leastPrimeFactor(int n) {
        // code here
        /*
        Initially every number is smallest prime factor of itself
        then we do sieve
        and get the primes and mark its multiples with prime
        
        Time Complexity = O(N log log N)
        Space Complexity = O(N)
        */
        int sieve[] = new int[n+1];
        for(int i=0;i<=n;i++) sieve[i]=i;
        for(int i=2;i*i<=n;i++){
            if(sieve[i]==i){
                for(int j=i*i;j<=n;j+=i){
                    if(sieve[j]==j){
                        sieve[j] = i;
                    }
                }
            }
        }
        
        return sieve;
    }
}
