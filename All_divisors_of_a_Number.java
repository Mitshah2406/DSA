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
