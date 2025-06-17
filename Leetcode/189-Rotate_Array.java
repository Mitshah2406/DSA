class Solution {
    public void reverse(int arr[], int st, int end){
        while(st<=end){
            int t = arr[st];
            arr[st] = arr[end];
            arr[end] = t;
            st++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        // 7 6 5 4 3 2 1 - reverse entire arr
        // 5 6 7 4 3 2 1 - reverse first k element
        // 5 6 7 1 2 3 4 - reverse n-k elements from last
        int n = nums.length;
        k = k%n;
        reverse(nums, 0,n-1);
        reverse(nums, 0,k-1);
        reverse(nums, k, n-1);
    }
}