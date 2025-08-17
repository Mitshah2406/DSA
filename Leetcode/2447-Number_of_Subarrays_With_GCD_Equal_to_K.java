class Solution {
    private int gcd(int a, int b){
        if(a==0) return b;
        if(a>b) return gcd(a%b,b);
        return gcd(b%a,a);
    }
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        // running subarray gcd 
        // time - O(n^2 * log(min(arr)))
        int cnt = 0;
        for(int s=0;s<n;s++){
            int g = 0;
            for(int e=s;e<n;e++){
                g = gcd(g,nums[e]);
                if(g==k) cnt++;
            }
        }
        return cnt;


    }
}