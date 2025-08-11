class Solution {
    /**
    Intuition = Same as power set just makes use of hashset to remove duplicates
    TC: O(2^TOTAL * N), SC: O(2^TOTAL * N)
     */
    private boolean checkBit(int n, int k){
        return (n&(1<<k))!=0;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> arr = new ArrayList<>();
        int total = (1<<n);
        Arrays.sort(nums); // sorting to maintain order so hashset can easily identify dups
        HashSet<List<Integer>> hs = new HashSet<>();
        for(int i=0;i<total;i++){
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(checkBit(i,j)){
                    res.add(nums[j]);
                }
            }
            if(!hs.contains(res)){
                arr.add(res);
                hs.add(res);
            }
        }

        return arr;
    }
}