class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(arr[mid]==target){
                return mid;
            }

            if(arr[left]<=arr[mid]){ // left half is sorted
                if(arr[left]<=target && target<=arr[mid]){
                    // eliminate other part
                    right = mid-1;
                }else{
                    left=mid+1;
                }
            }else if(arr[mid]<=arr[right]){ // right half
                if(arr[mid]<=target && target<=arr[right]){
                    // eliminate other part
                    left = mid+1;
                }else{
                    right=mid-1;
                }
            }
        }

        return -1;
    }
}