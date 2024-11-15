class Solution {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Count Prefix to be Removed

        int r = n-1;
        int res = 0;
        while(r>0 && arr[r-1]<=arr[r]){
                r--;
        }
        res = r;
        // Count Postfix to be Removed


        int l = 0;

        while(l<r){
            // Expand Invalid Window

            while(r<n && arr[l]>arr[r]){
                    r++;
            }
            // Get Min Window to be removed
            res = Math.min(res, r-l-1);
            // Expand Left pointer/break
            if(arr[l]>arr[l+1]){
                break;
            }
            l++;
        }

        return res;
    }

}
