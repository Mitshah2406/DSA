class Solution {
    /**
    Brute - O(n^2) simple nested loop with O(1) space
    

    Optimal - O(N), O(N)

    Using prefix sum - [1,2,3,-3,1,1,1,4,2,-3]

    if sum of 0..j is n, and we are finding occurrences of k,
    then n = k + (n-k) 
    so look for occurrences of n-k in hm, and store the current n
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // Prefix Sum x No Of Subarrays

        hm.put(0,1); // default case 
        int sum = 0;
        int cnt = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i]; // n = k + (n-k) 

            // find n-k in hm
            cnt+=hm.getOrDefault(sum-k,0);

            // put new n in hm
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }

        return cnt;
    }
}