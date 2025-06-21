class Solution {
    public int maxSubArray(int[] arr) {
        // Brute - O(n^2) with prefix sum

        // Optimal - Kadane's Algorithm => O(n)
        // Two variables; sum and ans, sum just sums up, if its negative then sum resets,
        // ans takes max of sum & itself
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        int n = arr.length;

        for(int i=0;i<n;i++){
            if(sum>=0){
                sum+=arr[i];
            }else{
                sum=arr[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}