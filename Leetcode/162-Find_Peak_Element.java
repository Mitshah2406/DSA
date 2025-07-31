class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n==1) return 0;              
        if(arr[0]>arr[1]){
            return 0;
        }
        if(arr[n-1]>arr[n-2]){
            return n-1;
        }
        int low = 1;
        int high = n-2;

        while(low<=high){
            int mid = low + (high-low)/2;
            int midM1 = mid-1<0 ? Integer.MIN_VALUE : arr[mid-1];
            int midP1 = mid+1>=n ? Integer.MIN_VALUE : arr[mid+1];
            if(midM1 < arr[mid] && arr[mid] > midP1){
                return mid;
            }else if(midM1<arr[mid]){
                low = mid+1;
            }else if(arr[mid]>midP1){
                high = mid-1;
            }else{
                high = mid-1;//go anywhere, doesnt matter (reverse peak state) [1,2,**1**,2,1]
            }
        }

        return -1;
    }
}


// 121 - peak
// 345 - right
// 432 - left
