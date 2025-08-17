class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        // Code here
        // Traditional Fixed Size Sliding Window
        // O(n)
        // O(1)
        int n = arr.length;
        int sum = 0;
        int ans = 0;
        // calculating for first window
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        ans = sum;
        // next windows
        for(int i=k;i<n;i++){
            // remove sum of leaving element of last window
            sum-=arr[i-k];
            // add sum of new element in window
            sum+=arr[i];
            ans = Math.max(ans,sum);
        }
        
        return ans;
        
    }
}
