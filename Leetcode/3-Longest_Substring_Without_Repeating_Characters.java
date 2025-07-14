class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int arr[] = new int[256];
        Arrays.fill(arr,-1);
        int n = s.length();
        while(r<n){
            if(arr[s.charAt(r)]!=-1){
                if(arr[s.charAt(r)]>=l){
                    l = arr[s.charAt(r)] + 1;
                }
            }
            int len = r-l+1;
            maxLen = Math.max(maxLen, len);
            arr[s.charAt(r)]=r;
            r++;
        }

        return maxLen;
    }
}