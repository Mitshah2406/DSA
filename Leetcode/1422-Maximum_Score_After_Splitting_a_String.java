class Solution {
    public int maxScore(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();
        int prefixSum[] = new int[n];
        prefixSum[0] = arr[0] - '0';

        for (int i = 1; i < n; i++) {
            prefixSum[i] = ((arr[i] - '0') + prefixSum[i - 1]);
        }

        int ans = 0;
        int zeros=0;
        if(arr[0]=='0'){
            zeros++;
        }
        for (int i = 1; i < n; i++) {
            ans = Math.max(zeros+(prefixSum[n-1]-prefixSum[i-1]), ans);
            if (arr[i] == '0') {
                zeros++;
            }
        }
       
        return ans;
    }
}


