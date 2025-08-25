class Solution {
    private int brute(int arr[], int n){
        int ans = 0;
        for(int i=0;i<n;i++){
            int zeroes = 0;
            int ones = 0;
            for(int j=i;j<n;j++){
                if(arr[j]==1) ones++;
                else zeroes++;
                if(ones==zeroes) ans++;
            }
        }
        return ans;
    }
    private int optimal(int arr[], int n){
        // 1 - means 1
        // 0 - means -1
        // Same as count subarrays equals to k, (here it is 0)
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        hm.put(0,1);
        int sum = 0, cnt = 0;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                sum+=1;
            }else{
                sum-=1;
            }
            
            cnt+=hm.getOrDefault(sum,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
            
        }
        
        return cnt;
    }
    public int countSubarray(int[] arr) {
        // code here
        int n = arr.length;
        
        // return brute(arr,n);
        return optimal(arr,n);
    }
}
