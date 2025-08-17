class Solution {
        /*
    "I will die, but also take others with me"
    Mark multiples of primes as false, bcoz they cannot be prime
    
    Visual demonstration of why we start from i*i:
    
    When i=2: Mark 2×2, 2×3, 2×4, 2×5, 2×6, 2×7...
    ┌─────┬─────┬─────┬─────┬─────┬─────┐
    │2×2=4│2×3=6│2×4=8│2×5=10│2×6=12│2×7=14│ ✓ All marked
    └─────┴─────┴─────┴─────┴─────┴─────┘
    
    When i=3: Mark 3×3, 3×4, 3×5, 3×6, 3×7...
    ┌─────┬─────┬─────┬─────┬─────┐
    │3×2=6│3×3=9│3×4=12│3×5=15│3×6=18│ 
    └─────┴─────┴─────┴─────┴─────┘
           ↑                     
         Start here! 3×2 already marked by i=2
    
    When i=5: Mark 5×5, 5×6, 5×7...
    ┌──────┬──────┬──────┬──────┐
    │5×2=10│5×3=15│5×4=20│5×5=25│
    └──────┴──────┴──────┴──────┘
     ✓       ✓       ✓       ↑
     Already marked by i=2,3,2  Start here!
    
    When i=7: Mark 7×7, 7×8, 7×9...
    ┌──────┬──────┬──────┬──────┬──────┬──────┬──────┐
    │7×2=14│7×3=21│7×4=28│7×5=35│7×6=42│7×7=49│...  │
    └──────┴──────┴──────┴──────┴──────┴──────┴──────┘
     ✓       ✓       ✓       ✓       ✓       ↑
     All already marked by smaller primes    Start here!
    
    In inner loop, we start from i*i instead of i, because
    all smaller multiples of i would have already been marked
    by smaller primes and increment by i, to just jump to multiples
    
    In outer loop, we start from 2, as it is the first prime
    go till root(n) because any composite number > sqrt(n)
    would have already been marked by its smaller prime factors
    
    Time Complexity: O(n*log(log(n))). 
    For each prime number, we mark its multiples, which takes around n/p steps. 
    The total time is proportional to n*(1/2 + 1/3 + 1/5 + ....).
    This sum over primes grows slowly and is 
    approximately O(n*log(log(n))) making the algorithm very efficient.
    Auxiliary Space: O(n)


    */

    private void performSieve(int n, boolean primes[]){
        primes[0] = primes[1] = false;
        for(int i=2;i*i<=n;i++){
            if(primes[i]){
                for(int j=i*i;j<=n;j+=i){
                    primes[j]=false;
                }
            }
        }
    }
    public int[] sieve(int n) {
        // code here
        boolean primes[] = new boolean[n+1];
        Arrays.fill(primes,true);
        
        
        int primeCount =0;
        performSieve(n, primes);
        int k = 0;
        for(int i=0;i<=n;i++){
            if(primes[i]) primeCount++;
        }
        int res[] = new int[primeCount];
        for(int i=2;i<=n;i++){
            if(primes[i]){
                res[k++] = i;
            }
        }
        
        return res;
    }
}
