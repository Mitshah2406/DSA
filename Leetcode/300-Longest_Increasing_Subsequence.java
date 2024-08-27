class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int bs[] = new int[n];
        int ans = 0;
       
        for(int i=0;i<n;i++){
            int low = 0;
            int high = ans;
            while(low<high){
                int mid = low + (high-low)/2;

                if(bs[mid]<arr[i]){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
            bs[low] = arr[i];
            if(low==ans){
                ans++;
            }
        }

        return ans;
    }
}