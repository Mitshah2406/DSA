class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();

        int n = nums.length;
        for(int i:nums){
            if(hs.contains(i)) return true;
            hs.add(i);
        }
        return false;
    }
}