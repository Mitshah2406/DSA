class Solution {
    private boolean checkBit(int n, int k){
        if((n&(1<<k))==0){
            return false;
        }

        return true;
    }
    public int minBitFlips(int start, int goal) {
        if(start==goal) return 0;
        // StringBuilder og = new StringBuilder();
        // StringBuilder target = new StringBuilder();


        int ans=0;
        int place = 0;
        for(int i=0;i<32;i++){
            place = place + (int)Math.pow(2,i);
            char f = '0';
            char s = '0';
            if(checkBit(start,i)){
                f = '1';
            }
            if(checkBit(goal,i)){
                s = '1';
            }
            if(f!=s){
                ans++;
            }
            if(start<place && goal<place){
                break;
            }
        }
       
        return ans;
    }
}