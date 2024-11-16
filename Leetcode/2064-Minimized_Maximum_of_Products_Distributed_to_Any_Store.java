class Solution {
    public boolean valid(int distri, int arr[], int n){
        int stores = 0;

        for(int i :arr){
            stores += (int) Math.ceil((double)i/distri);
        }

        return stores<=n;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int max = -1;
        for(int i:quantities){
            max = Math.max(max, i);
        }

        int l = 1;
        int r = max;
        int ans = max;
        // 1,2,3,4,5,6,7,8,9,10,11
        while(l<=r){
            int mid = l+(r-l)/2;

            if(valid(mid, quantities, n)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return ans;
    }
}