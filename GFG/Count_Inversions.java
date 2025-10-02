class Solution {
    private void merge(int arr[], int st, int mid, int end){
        int res[] = new int[end-st+1];
        int i = st, j = mid+1, k = 0;
        
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                res[k++] = arr[i++];
            }else{
                res[k++] = arr[j++];
            }
        }
        
        while(i<=mid){
            res[k++] = arr[i++];
        }
        
        while(j<=end){
            res[k++] = arr[j++];
        }
        
        for(int e=0;e<res.length;e++){
            arr[e+st] = res[e];
        }
        
    }
    private void mSort(int arr[], int l, int r){
        
        if(l<r){
            int mid = l + (r-l)/2;
            mSort(arr, l, mid);
            mSort(arr,mid+1, r);
            
            merge(arr, l , mid, r);
        }
    }
    void mergeSort(int arr[], int l, int r) {
        // code here
        int n = arr.length;
        
        mSort(arr, l ,r);
    }
}

/**
 * Time - O(nlogn)
 * Space - O(n) 
 * /
