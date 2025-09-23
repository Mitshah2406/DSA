class Solution {
    private void reverse(int arr[], int st, int end) {
        while (st <= end) {
            int t = arr[st];
            arr[st] = arr[end];
            arr[end] = t;
            st++;
            end--;
        }
    }

    private void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // 1. find longest prefix
        int idx = -1; // mountain idx 
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            // if no mnt idx, then reverse the array and return
            reverse(nums, 0, n - 1);
            return;
        }

        // 2. Find closest greater element to swap
        int scd = -1;
        for (int i = n - 1; i >= idx; i--) {
            if (nums[i] > nums[idx]) {
                // since going from reverse array, this will be closest
                swap(nums, i, idx);
                break;
            }
        }

        // 3. Reverse the idx+1 to n-1 part to get lexicographically smallest permutation greater than current
        reverse(nums, idx + 1, n - 1);
    }
}