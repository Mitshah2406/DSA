class Solution {
    public int binarySearch(int low, int high, int arr[], int x, boolean isFirst) {
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                idx = mid;
                if (isFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return idx;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int first = binarySearch(0, n - 1, nums, target, true);
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        int last = binarySearch(0, n - 1, nums, target, false);
        if (last == -1) {
            return new int[] { -1, -1 };
        }

        return new int[] { first, last };

    }
}