class Solution {
    private boolean checkBit(int k, int n){
        if(((1<<k)&n)==0){
            return false; // unset
        }
        return true; // set
    }
    public int findComplement(int num) {
        StringBuilder s = new StringBuilder();
        int place = 0;
        int ans=0;
        for(int i=0;i<=31;i++){
            if(ans==num) break;
            if(place==0) place=1;
            else place*=2;
            if(checkBit(i, num)){
                // set
                ans += place;
                s.append("0");
            }else{
                // unset
                s.append("1");
            }
        }
        // System.out.println(s);
        return Integer.parseInt(s.reverse().toString(), 2);
    }
}