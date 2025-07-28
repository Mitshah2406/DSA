
class Solution {
    public static int LongestBitonicSequence(int n, int[] arr) {
        // code here
        // take out both lis & lds 
        // then bitonic = lis+lds-1 (-1 for curr element)
        
        /*
        Time Complexity = O(n^2) + O(n^2) = O(2(n^2)) = O(n^2)
        Space Complexity = O(N) + O(N) = O(2N) = O(N)
        */
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        

        
        for(int i=0;i<n;i++){
            dp1[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && dp1[i]<dp1[j]+1){
                    dp1[i] = dp1[j]+1;
                }
            }
        }
        
        int maxBitonic = 0;
        for(int i=n-1;i>=0;i--){
            dp2[i] = 1;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[i] && dp2[i]<dp2[j]+1){
                    dp2[i] = dp2[j]+1;
                }
            }
            // System.out.println(dp1[i] + " "+dp2[i]);
            if(dp1[i]!=1 && dp2[i]!=1){
                maxBitonic = Math.max(dp1[i]+dp2[i]-1, maxBitonic);
            }
            
        }
        
        return maxBitonic;
    }
}
