class Solution {
    public int[] shuffle(int[] nums, int n) {
        // Brute Force. withn O(n) space
        // int ans[] = new int[n+n];
        // int j = 0;
        // for(int i=0;i<n;i++){
        //     ans[j++] = nums[i];
        //     ans[j++] = nums[i+n]; 
        // }
        // return ans;

        // Optimal - O(n) time with O(1) space
        // [x,x,x,y,y,y] => [x,y,x,y,x,y]

        for(int i=0;i<n;i++){
            nums[i] = nums[i]<<10; // make space for corresponding y
            // store y as we shifted 10 bits, so all zeros, and or means 
            // just copying the 1 bit if exist
            nums[i] = nums[i] | nums[i+n]; 
        }
        int j = (n*2)-1;
        for(int i=n-1;i>=0;i--){
            // extract y 
            int y = nums[i] & (((int)Math.pow(2,10))-1);// bitwise and all set 9 bits to get to originai y bits
            int x = nums[i] >> 10; // right shift the x bits by 10
            nums[j--] = y; // keep placing from behind
            nums[j--] = x; 
        }

        return nums;
    }
}

// 1024 512 128 64 32 16 8 4 2 1
// 1    0   0   0  0  0  0 0 0 0 (do minus 1) taking 9 bits coz 10^=3 can be represented in max 9 bits
// 0    1   1   1  1  1  1 1 1 1