class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        int lessL[] = new int[n];
        int lessR[] = new int[n];
        int moreR[] = new int[n];
        int moreL[] = new int[n];

        for(int i=1;i<n-1;i++){
            int less = 0;
            int more = 0;

            for(int j=0;j<i;j++){
                if(rating[i]<rating[j]) more++;
                else less++;
            }
            moreL[i] = more;
            lessL[i] = less;
            more=0;
            less=0;

            for(int j=i+1;j<n;j++){
                if(rating[i]<rating[j]) more++;
                else less++;
            }
            moreR[i] = more;
            lessR[i] = less;
            more=0;
            less=0;


            count+=lessL[i]*moreR[i];
            count+=moreL[i]*lessR[i];
        }

        

        

        return count;
    }
}