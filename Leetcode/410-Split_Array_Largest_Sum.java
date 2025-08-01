class Solution {
    // Helper function to check if array can be split into <= k subarrays 
    // such that the largest subarray sum is <= sumAllowed
    private boolean canSplit(int arr[], int n, int k, int sumAllowed){
        int usedSplit = 1; // Start with 1 split (entire array initially)
        int curr = 0; // Current subarray sum

        for(int i = 0; i < n; i++){
            if(curr + arr[i] > sumAllowed){ 
                // If adding arr[i] exceeds allowed sum, start a new split
                curr = arr[i];
                usedSplit++;
            } else {
                curr += arr[i]; // Continue adding to current subarray
            }
        }
        return usedSplit <= k; // Check if splits used are within limit
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE; // Largest element (lower bound for answer)
        int sum = 0; // Total sum (upper bound for answer)

        // Compute max element and total sum
        for(int e : nums){
            max = Math.max(e, max);
            sum += e;
        }

        int low = max; // Minimum possible largest subarray sum
        int high = sum; // Maximum possible largest subarray sum

        // Binary search on answer (minimum largest subarray sum)
        while(low <= high){
            int mid = low + (high - low) / 2; 
            if(canSplit(nums, n, k, mid)){ 
                // If possible to split with this mid, try smaller answer
                high = mid - 1;
            } else { 
                // Otherwise, increase allowed sum
                low = mid + 1;
            }
        }

        return low; // Low will be the minimized largest subarray sum
    }
}

/*
Time Complexity:
- O(N * log(S)) 
  where N = length of nums,
  and S = (sum of elements - max element) range for binary search.
  - Binary search runs log(S)
  - Each check (canSplit) is O(N)

Space Complexity:
- O(1) (no extra space used)
*/
