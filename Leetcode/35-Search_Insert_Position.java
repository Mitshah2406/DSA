class Solution {
    /*
        Time - O(logn)
     */
    public int searchInsert(int[] arr, int target) {
    int n = arr.length;
    int low = 0;          // Start pointer at the beginning of the array
    int high = n - 1;     // End pointer at the last index

    // Binary search loop: runs while search space is valid
    while (low <= high) {
        int mid = low + (high - low) / 2;  // Find middle index safely

        // If mid element is greater than or equal to target:
        // - We might have found the target OR
        // - The target should be inserted before this mid
        // So, we shrink the search space to the LEFT half.
        if (arr[mid] >= target) {
            high = mid - 1;
        } 
        // If mid element is less than target:
        // - The target must be on the RIGHT side.
        else {
            low = mid + 1;
        }
    }

    // At this point, loop ends when low > high.
    // - 'high' points to the last index < target
    // - 'low' points to the first index >= target
    // Hence, 'low' is the correct insertion position.
    // If target exists, low will be its index.
    // If target doesn't exist, low is the place to insert it.
    return low;
}

}