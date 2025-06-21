class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // brute
        int n = nums.length;
        HashSet<List<Integer>> hs = new HashSet();
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> arr = new ArrayList();
        //                 arr.add(nums[i]);
        //                 arr.add(nums[j]);
        //                 arr.add(nums[k]);
        //                 Collections.sort(arr);
        //                 hs.add(arr);
        //             }
        //         }
        //     }
        // }

        // List<List<Integer>> ans = new ArrayList();
        // for (List<Integer> l : hs) {
        //     ans.add(l);
        // }

        // return ans;

        // better
        // HashMap<Integer, Integer> hm = new HashMap();
        // Arrays.sort(nums);
        // for (int i = 0; i < n; i++) {
        //     HashSet<Integer> t = new HashSet();
        //     for (int j = i + 1; j < n; j++) {
        //         int sum = (nums[i] + nums[j]);
        //         if (t.contains(-sum)) {
                    // List<Integer> arr = new ArrayList();
                    // arr.add(nums[i]);
                    // arr.add(nums[j]);
                    // arr.add(-sum);
                    // hs.add(arr);
        //         }
        //         t.add(nums[j]);
        //     }
        // }

        // List<List<Integer>> ans = new ArrayList();
        // for (List<Integer> l : hs) {
        //     ans.add(l);
        // }

        // return ans;


        // best - two pointer approach

        // i as constant till j crosses k
        // if sum < 0 increment j
        // if sum > 0 decrement k
        // otherwise add the pair, and discard the same elements

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i=0;i<n;i++){
            int j = i+1;
            int k = n-1;
            if(i>0 && nums[i]==nums[i-1]) continue;
            while(j<k){
                int sum = nums[j]+nums[k]+nums[i];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    List<Integer> arr = new ArrayList();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(nums[k]);
                    ans.add(arr);
                    k--;
                    j++;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }

        return ans;
    }
}