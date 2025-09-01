// User function Template for Java

class Solution {
    private int brute(int arr[], int n, int k){
        int len = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==k){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
    private int optimal(int arr[], int n, int k){
        int len = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int p[] = new int[n];
        p[0] = arr[0];
        for(int i=1;i<n;i++){
            p[i] = p[i-1]+arr[i];
        }
        while(right<n){
            if(left==0){
                sum=p[right];
            }else{
                sum=p[right]-p[left-1];
            }
            
            while(sum>k){
                sum=p[right]-p[left];
                left++;
            }
            
            if(sum==k){
                len = Math.max(len, right-left+1);
            }
            
            right++;
        }
        
        return len;
    }
    public int longestSubarray(int[] arr, int k) {
        // code here
        int n = arr.length;
        return optimal(arr, n, k);
    }
}
