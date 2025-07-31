class Solution {
    public int checkBit(int n, int k){
        if((n&(1<<k))==0){
            return 0;
        }
        return 1;
    }
    public int hammingWeight(int n) {
        int ans = 0;
        for(int i=31;i>=0;i--){
            ans+=checkBit(n,i);
        }
        return ans;
    }
}