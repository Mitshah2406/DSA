class Solution {
    /**
    Time = O(N)
    Space = O(1)

    Put all of nums in set,
    then iterate on hs,
    on each element, loop till you find consecutive elements in hs, 
    but this essentially could create a N^2 loop,

    so if we are currently on a element e, and we see that e-1 element is present in set,
    then skip e, coz if we have already done the work or will be doing the work for e-1,
    e would be automatically covered.
     */
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        HashSet<Integer> hs = new HashSet<>();

        for (int e : nums) {
            hs.add(e);
        }
        int ans = 0;
        for (int e : hs) {
            int cnt = 1;
            if (!hs.contains(e - 1)) {
                int it = e + 1;
                while (hs.contains(it)) {
                    cnt++;
                    it++;
                }

                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}