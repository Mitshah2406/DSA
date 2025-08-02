class Solution {
    /*
    Approach:
    ---------
    We are tasked with finding the smallest divisor such that the sum of 
    ceil(arr[i] / divisor) for all elements in the array is less than or equal to 
    a given threshold. This is a classic "binary search on answer" problem.
    
    1. Search Space:
    - The divisor can range from '1' (smallest possible divisor) to 'max(nums)' (largest number in the array).
    
    2. Binary Search:
    - We perform binary search over this range of possible divisors.
    - For each 'mid' (candidate divisor), we calculate the sum of 
     'ceil(arr[i] / mid)' for all 'i'.
    - If this sum is <= threshold, we can try a smaller divisor (move left), 
     else we increase the divisor (move right).
    
    3. Helper Function ('canDo'):
    - Given a divisor, it checks if using this divisor keeps the total sum 
     <= threshold.
    
    4. Result:
    - The binary search narrows down to the smallest divisor that satisfies 
     the condition, which is returned as the answer.
    
    Time Complexity:
    ----------------
    - Binary Search: O(log(max(nums))) iterations.
    - Each Check (canDo): O(n) to iterate over all elements.
    - Overall: O(n * log(max(nums)))
    
    Space Complexity:
    -----------------
    - O(1): We use constant extra space.
    */

    private boolean canDo(int arr[], int n, int k, int divisor) {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            double ans = Math.ceil((double) arr[i] / (double) divisor);
            sum += ans;
        }
        return (int) sum <= k;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = -1;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canDo(nums, n, threshold, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}