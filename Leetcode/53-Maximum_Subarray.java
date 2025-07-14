class Solution {
    public int maxSubArray(int[] arr) {
        // // Brute Force
        // int n = arr.length;
        // int max = Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int sum = 0;
                
        //         for(int k=i;k<=j;k++){
        //             sum+=arr[k];
        //         }
        //         max = Math.max(sum,max);
        //     }
        // }
        // return max;
        
        
        // // Better
        // int n = arr.length;
        // int max = Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     int sum = 0;
        //     for(int j=i;j<n;j++){
                
        //         sum+=arr[j];
        //         max = Math.max(sum,max);
        //     }
        // }
        // return max;
        

        // Optimal - Kadane's Algorithm => O(n)
        // Two variables; sum and ans, sum just sums up, if its negative then sum resets,
        // ans takes max of sum & itself
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        int n = arr.length;
        int start=-1;
        int ansSt=-1;
        int ansEnd=-1;
        for(int i=0;i<n;i++){
            if(sum==0) start=i;
            sum+=arr[i];
            if(ans<sum){
                ans = sum;
                ansSt = start;
                ansEnd = i;
            }
            if(sum<0) sum=0;
        }
        return ans;
    }
}