// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

       int n = arr.length;
       
       int sum = 0;
       int ans = Integer.MIN_VALUE;
       
       for(int i: arr){
           sum += i;
           ans = Math.max(ans, sum);
           if(sum<0){
               sum = 0;
           }
       }
       return ans;
       
    }
}
