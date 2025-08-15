class Solution {
    private int checkBit(int n, int k) {
        return (n & (1 << k)) != 0 ? 1 : 0;
    }

    public List<Integer> grayCode(int n) {
        /**
        Time = O(2^n * n) = O(2^16 * 16)
        Space = O(2^n) = O(2^16)
         */
        // List<Integer> arr = new ArrayList<>();

        // int totalNums = 1 << n;
        // for (int i = 0; i < totalNums; i++) {
        //     // first loop for n bits in reverse
        //     int num = 0;
        //     int lastBit = 0;
        //     for (int j = n - 1; j >= 0; j--) {
        //         int bit = checkBit(i, j);
        //         if (j == n - 1) {
        //             // just append
        //             num = num | bit << j; // anything orred keeps the set bits of both numbers intact, 0<<j, 1<<j

        //         } else {
        //             int rBit = lastBit ^ bit;
        //             num = num | rBit << j;
        //         }
        //         lastBit = bit;
        //     }
        //     arr.add(num);
        // }
        // return arr;



        /**
        OPTIMAL
        * Intuition:
        * Gray code is defined such that each successive number differs by only 1 bit.
        * 
        * If we write binary as: b3 b2 b1 b0
        * Then shifting right by 1 gives: 0 b3 b2 b1
        * 
        * Taking XOR:
        *   i      = b3   b2   b1   b0
        *   i>>1   = 0    b3   b2   b1
        *   i^(i>>1) = b3 (b3^b2) (b2^b1) (b1^b0)
        * 
        * This matches the Gray code rules:
        *   - MSB stays the same
        *   - Each next bit = XOR of current and previous binary bit
        * 
        * Thus, Gray(i) = i ^ (i >> 1)
        * 
        * Time Complexity:
        *   O(2^n)  -> we generate 2^n numbers, each in O(1)
        * Space Complexity:
        *   O(2^n)  -> to store the sequence
        */

        List<Integer> arr = new ArrayList<>();
        int total = 1<<n;

        for(int i=0;i<total;i++){
            arr.add(i ^ (i>>1));
        }
        return arr;
    }
}