class Solution {
    public int singleNonDuplicate(int[] nums) {
        // brute
        // time = O(n)
        // space = O(logn)
        int n = nums.length;
        // HashMap<Integer, Integer> hm = new HashMap();
        // for(int i: nums){
        //     hm.put(i, hm.getOrDefault(i, 0)+1);
        // }

        // for(Map.Entry<Integer, Integer> e: hm.entrySet()){
        //     if(e.getValue()==1){
        //         return e.getKey();
        //     }
        // }
        // return 0;

        // better
        // worst case if ans is last element then O(n/2) = O(n)
        // space = O(1);
        // if(n==1) return nums[0];
        // for(int i=0;i<n;i+=2){
        //     if(i+1<n && nums[i]!=nums[i+1]){
        //         return nums[i];
        //     }
        // }
        // return nums[n-1];

        // optimal = binary search
        // if first element of pair = then should be even idx, if not -> go to left keeping mid
        // if second element of pair = then should be odd idx, if not go to left keeping mid
        // Time = O(logn), Space = O(1)
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 1) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[left];
    }
}