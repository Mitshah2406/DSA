class Solution {
    /* 
        XOR Truth table (Same bits is false, otherwise true)
        | A | B | A ^ B (XOR) |
        | - | - | ----------- |
        | 0 | 0 | 0           |
        | 0 | 1 | 1           |
        | 1 | 0 | 1           |
        | 1 | 1 | 0           |

        therefore, the numbers which appears twice become zero, leaving behind the number appearing once

        TC = O(N)
        SC = O(1)
    */
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int n: nums){
            xor^=n;
        }
        return xor;
    }
}