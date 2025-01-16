class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int res = 0;

        // for(int i=0;i<len1;i++){
        //     int f = nums1[i];
        //     for(int j=0;j<len2;j++){
        //         int s = nums2[j];

        //         int xor = f^s;
        //         res = res^xor;
        //     }
        // }
        // return res;
        // xor property

        // x xor x = 0
        // 0 xor x = x

        // therefore if count of any number is even ans is 0
        // if odd then number itself

        // so if len1 is odd do xor of whole nums2 and vice versa
        // if both odd do xor of both
        if(len2%2==1){
            for(int i=0;i<len1;i++){
                res = res^nums1[i];
            }
        }
        if(len1%2==1){
            for(int i=0;i<len2;i++){
                res = res^nums2[i];
            }
        }

        return res;
    }
}