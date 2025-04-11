class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for(int i=low;i<=high;i++){
            String s = Integer.toString(i);

            int n = s.length();
            if(n%2==1){
                continue;
            }
            int st = 0;
            int mid = n/2;
            int end = mid;
            int sum1 = 0;
            int sum2 = 0;
            while(st<mid){
                sum1+=s.charAt(st)-'0';
                sum2+=s.charAt(end)-'0';
                st++;
                end++;
            }
                
            if(sum1==sum2) ans++;
        }

        return ans;
    }
}