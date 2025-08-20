class Solution {
    private int subarrayWithKDifferentIntegers(int arr[], int n, int k) {
        if (k < 0)
            return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int left = 0, right = 0, ans = 0;

        while (right < n) {
            int occ = hm.getOrDefault(arr[right], 0) + 1;
            hm.put(arr[right], occ);

            while (hm.size() > k) { // cannot keep it to valid len as we want count of valid subarrays
                int tempOcc = hm.get(arr[left]) - 1;
                if (tempOcc <= 0) {
                    hm.remove(arr[left]);
                } else {
                    hm.put(arr[left], tempOcc);
                }
                left++;
            }
            ans += (right - left + 1);
            right++;
        }
        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        /**
        BRUTE FORCE
        -> Time - O(n^2), Space - O(1)
        Simple n^2 loop
         */
        // int n = nums.length;
        // int ans = 0;
        // for(int i=0;i<n;i++){
        //     HashMap<Integer, Integer> hm = new HashMap<>();
        //     for(int j=i;j<n;j++){
        //         hm.put(nums[j], hm.getOrDefault(nums[j],0)+1);

        //         if(hm.size()==k){
        //             ans++;
        //         }
        //         if(hm.size()>k) break;
        //     }
        // }

        // return ans;

        /**
        OPTIMAL - 
        Time - O(2x2N), Space - O(2xN)
        Normal Sliding Window
        Subarrays equals to k = (Subarrays <= k) - (Subarrays <= k-1)
        */

        int n = nums.length;
        return subarrayWithKDifferentIntegers(nums, n, k)-subarrayWithKDifferentIntegers(nums, n, k - 1);
    }
}