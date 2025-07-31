class Solution {
    private static int binarySearch(int low, int high, int x, int arr[]){
        int ans = -1;
        while(low<=high){

            int mid = low + (high-low)/2;
            if(arr[mid]<=x){
                 low = mid+1;
                 ans = mid;
            }else if(arr[mid]>x){
                high = mid-1;
            }
        }
        return ans;
    }
    public int findFloor(int[] arr, int x) {
        // code here
        int n = arr.length;
        return binarySearch(0,n-1,x,arr);
    }
}
