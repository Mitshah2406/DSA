class Solution {
    /*
    Time - O(n) * O(nlogn)
    Space = O(1)
     */
    private int checkDaysTaken(int arr[], int n, int capacity) {
        int curr = 0;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if(arr[i]+curr>capacity){
                ans++;
                curr = arr[i];
            }else{
                curr += arr[i];
            }
        }
        return ans;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int n = weights.length;
        int max = -1;
        for (int i : weights) {
            sum += i;
            max = Math.max(max, i);
        }
        int low = max; // take max as capacity should be max ele to accumulate max weight, otherwise no use, 
        int high = sum; // container capacity of sum for all weights in one day

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int daysTook = checkDaysTaken(weights, n, mid);
            if (daysTook <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}