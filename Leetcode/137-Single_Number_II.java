class Solution {
    // add all bits at positions and then mod them by 3, where u get 1, append it
    // tc= O(N), sc = O(1)
    public int checkBit(int n, int k){
        if((n&(1<<k))==0){
            return 0;
        }
        return 1;
    }
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int res = 0;
        for(int j=0;j<32;j++){
            sum = 0;
            for(int i=0;i<n;i++){
                sum += checkBit(nums[i],j);
            }
            if(sum%3!=0){
                res+=1<<j;
            }
        }
       return res;
    }
}