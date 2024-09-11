class Solution {
    private boolean checkBit(int n, int k) {
        if ((n & (1 << k)) == 0) {
            return false; // unset
        }
        return true; // set
    }

    public int minBitFlips(int start, int goal) {
        if (start == goal)
            return 0;
        int ans = 0;
        int place = 0;
        for (int i = 0; i < 32; i++) {
            place = place + (1 << i); // binary number logic ==> ...64 32 16 8 4 2 1
            if ((checkBit(start, i) ^ checkBit(goal, i))) {
                // if bits are diff then xor will result in true, which we want
                ans++;
            }
            if (start <= place && goal <= place) {
                break;
            }
        }

        return ans;
    }
}