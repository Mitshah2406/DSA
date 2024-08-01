class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(String passenger: details){
            if(Integer.parseInt(passenger.substring(11,13))>60){
                ans++;
            }
        }
        return ans;
    }
}

// 1st ten ch = phno
//following ch - gender
//next 2 for age
//last two for seat alloted