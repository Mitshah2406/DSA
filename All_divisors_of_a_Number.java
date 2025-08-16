class Solution {
    public static void print_divisors(int n) {
        /*
        BRUTE FORCE = O(n), O(1)
        basic divisor check and printing
        */
        // for(int i=1;i<=n;i++){
        //     if(n%i==0){
        //         System.out.print(i+" ");
        //     }
        // }
        
        
        /*
        OPTIMAL
        i * j  = N(36) // Printing all factors
        1 * 36 = 36
        2 * 18 = 36
        3 * 12 = 36
        4 * 9  = 36
        6 * 6  = 36
        ------------
        9 * 4  = 36
        12 * 3 = 36
        18 * 2 = 36
        36 * 1 = 36
        
        the line drawn, we need to go till there only which i=6 that is root of 36
        because whenever a number is factor of N, the other multiplier is also a factor, so we add both
        
        i*j = N; 
        i = 1, N= 36; j = N/i == ADD both i and N/i
        Time = O(root(n)) + O(no of factors * log * no of factors) + O(no of factors)
        Space = O(no of factors)
        basic divisor check and printing
        */
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                arr.add(i);
                if(i!=n/i){
                    arr.add(n/i);
                }
            }
        }
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
    }
}
