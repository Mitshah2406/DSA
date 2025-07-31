class Solution {
    private boolean allocate(int arr[], int n, int k, int maxPages){
        int stud = 1;
        int curr = 0;
        int max = -1;
        for(int i=0;i<n;i++){
            if(arr[i]+curr>maxPages){
                stud++;
                max = Math.max(max, curr);
                curr = arr[i];
            }else{
                curr+=arr[i];
            }
        }
        // if all students dont recieve book, 
        // yet ans will be correct, as there is more space to keep books,
        // so binary search lowers the values further
        return stud<=k; 
    }
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(k>n) return -1;
        int sum = 0;
        int max = 0;
        for(int i:arr){
            sum+=i;
            max = Math.max(max,i);
        }
        int low = max; // valid side [polarity]
        int high = sum; // invalid side[polarity]
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(allocate(arr,n,k,mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return low;
    }
}
