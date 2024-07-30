class Solution {
    public int[] twoSum(int[] nums, int k) {

        int n = nums.length;
        int temp[] = nums.clone();
        int i = 0;
        int j = n - 1;
        int res[] = new int[2];
        Arrays.sort(nums);
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < k) {
                i++;
            } else if (sum > k) {
                j--;
            } else {
                res[0] = i;
                res[1] = j;
                break;
            }
        }
        boolean flag1 = true;
        boolean flag2 = true;
        for(int m=0;m<n;m++){
            if(temp[m] == nums[res[0]]&&flag1){
                flag1=false;
                res[0]=m;
            }else if(temp[m] == nums[res[1]] && flag2){
                 flag2=false;
                res[1]=m;
            }
        }
        return res;
    }
}