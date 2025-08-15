class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        
        /* Brute - Time - O(n^2) space - O(n)
        Just do a n^2 loop with prefix sum concept (just ^ instead of +)
        4,2,3,5 [xor of 2 to 5]
        xor of whole arr ^ xor of start-1
        it will cancel all elements before start and we will get xor of the subarray
        
        */
        // int n = arr.length;
        // int prefix[] = new int[n];
        // prefix[0] = arr[0];
        
        // for(int i=1;i<n;i++){
        //     prefix[i] = prefix[i-1] ^ arr[i];
        // }
        // int ans = 0;
        // for(int s=0;s<n;s++){
        //     if(arr[s]==k) ans++;
        //     for(int e=s+1;e<n;e++){
        //         if(s==0){
        //             int xor = prefix[e];
        //             if(xor==k) ans++;
        //         }else{
        //             int xor = prefix[e] ^ prefix[s-1];
        //             if(xor==k) ans++;
        //         }
        //     }
        // }
        
        // return ans;
        
        
        /* Better -  Time - O(n^2) space - O(1)
        Do a running xor  
        */
        // int n = arr.length;
        // int ans = 0;
        // for(int s=0;s<n;s++){
        //     int xor = 0;
        //     for(int e=s;e<n;e++){
        //         xor^=arr[e];
        //         if(xor==k) ans++;
        //     }
        // }
        
        // return ans;
        
        
        /* Optimal  = Time - O(n) space - O(n)
        Here xor means xor till that index from start, 
        x means part before start point, k measn start to end xor
           xor
        ---------
        ===~~~~~~
         x    k
        
        so, we fix the end point and we do 
        x^k=xor
        do xor k on both sides;
        (x^k)^k = xor^k
        x = xor^k; therefore everytime check for xor^k which we will x i.e number of starting points
        that can get us ans as k for any subarray ending at ith index
        */
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // xor X count
        
        hm.put(0,1); // default case if subarray starts from 0
        int xor = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            xor^=arr[i];
            ans+=hm.getOrDefault(xor^k, 0);
            
            hm.put(xor, hm.getOrDefault(xor,0)+1);
        }
        
        
        return ans;
    }
}
