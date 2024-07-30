class Solution {
    public int minimumDeletions(String s) {
        int b = 0;
        int ans = 0;

        for(char ch: s.toCharArray()){
            if(ch=='b'){
                b++;
            }else{
                if(b>0){
                    ans++;
                    b--;
                }
            }
        }

        return ans;
    }
}