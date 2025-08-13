public class Solution {
    public static int[] findMissingRepeatingNumbers(int []a) {

        // Math Approach  ---- O(n), O(1)
        int n = a.length;

        long sum = 0;
        long sumSq = 0;

        for (int val : a) {
            sum += val;
            sumSq += (long) val * val;
        }

        long sumN = (long) n * (n + 1) / 2;
        long sumNSq = (long) n * (n + 1) * (2L * n + 1) / 6;

        // x = repeating, y = missing
        long first = sum - sumN;           // x - y
        long e = sumSq - sumNSq;           // x? - y? = (x - y)(x + y)
        long second = e / first;           // x + y

        long x = (first + second) / 2;     // repeating
        long y = x - first;                // missing

        return new int[]{(int) x, (int) y};



        // Bit Approach -  ---- O(n), O(1)
        // int n = a.length;

        // int xorr = 0;
        // for(int i=0;i<n;i++){
        //     // include arr elements as well as 1..N
        //     xorr ^= a[i];
        //     xorr ^= (i+1);
        // }

        // int bitNo = 0;
        // while(true){
        //     // find first bit which is set
        //     if((xorr&(1<<bitNo))!=0){
        //         break;
        //     }
        //     bitNo++;
        // }
        // int zero = 0;
        // int one = 0;
        // for(int i=0;i<n;i++){
        //     // checking if that particular bit which is chosen is set or not
        //     if((a[i]&(1<<bitNo)) != 0){
        //         one ^=a[i];
        //     }else{
        //         zero ^=a[i];
        //     }
        // }
        // for(int i=1;i<=n;i++){
        //     // checking if that particular bit which is chosen is set or not
        //     if((i&(1<<bitNo)) != 0){
        //         one ^=i;
        //     }else{
        //         zero ^=i;
        //     }
        // }

        // int cnt = 0;
        // for(int i=0;i<n;i++){
        //     // cnt will be 2 for repeating number
        //     if(a[i]==zero) cnt++;
        // }

        // if(cnt==2) return new int[]{zero,one};
        // return new int[]{one,zero};
    }
}
