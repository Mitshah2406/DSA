class Solution {
    public int getLucky(String s, int k) {
        // StringBuilder ans = new StringBuilder();
        // int n = s.length();
        // for (int i = 0; i < n; i++) {
        //     ans.append(s.charAt(i) - 96);
        // }
        // int transform = 0;
        // int res = -1;
        // while (k != 0) {
        //     for (int i = 0; i < ans.length(); i++) {
        //         transform += (ans.charAt(i) - '0');
        //     }
        //     if (k == 1) {
        //         return transform;
        //     } else {
        //         ans.setLength(0);
        //         ans.append(Integer.toString(transform));
        //         res = transform;
        //         transform = 0;
        //     }
        //     k--;
        // }

        // return res;


        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 96;

            while(c>0){
                int rem = c%10;
                c = c/10;

                sum+=rem;
            }
        }
        int res = 0;
        k--;

        while(k>0){
            while(sum>0){
                int rem = sum%10;
                sum = sum/10;
                res+=rem;
            }
            sum = res;
            res=0;
            k--;
        }

        return sum;
    }
}