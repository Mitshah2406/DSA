class Solution {
    // Helper function to check if we can paint all boards within 'time' using <= k painters
    private boolean canPaint(int arr[], int n, int k, int time){
        int paintersUsed = 1; // Start with 1 painter
        int curr = 0; // Track current painter's workload
        
        for(int i=0; i<n; i++){
            // If adding current board exceeds time limit, assign a new painter
            if(curr + arr[i] > time){
                curr = arr[i];  // New painter starts with this board
                paintersUsed++;
            } else {
                curr += arr[i]; // Add board to current painter's workload
            }
        }
        return paintersUsed <= k; // Check if painters used are within limit
    }
    
    public int minTime(int[] arr, int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE; // Max board length (lower bound of time)
        int sum = 0; // Total sum of board lengths (upper bound of time)
        
        // Calculate max and sum
        for(int ele: arr){
            max = Math.max(max, ele);
            sum += ele;
        }
        
        int low = max;  // Minimum possible time (at least largest board length)
        int high = sum; // Maximum possible time (one painter paints all)
        
        // Binary search over possible minimum times
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canPaint(arr, n, k, mid)){
                high = mid - 1; // Try to minimize time
            } else {
                low = mid + 1;  // Increase time if not possible
            }
        }
        return low; // 'low' will be the minimum time required
    }
}

/*
Time Complexity:
- O(N * log(S)) where N = number of boards, 
  and S = sum of all board lengths (binary search range).

Space Complexity:
- O(1) → Constant extra space used.
*/
