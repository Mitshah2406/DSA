class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int sum = 0;
        int max = 0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        max = Math.max(max, sum);
        
        for(int i=k;i<n;i++){
            sum-=arr[i-k];
            sum+=arr[i];
            max = Math.max(max, sum);
        }
        
        return max;
    }
}
