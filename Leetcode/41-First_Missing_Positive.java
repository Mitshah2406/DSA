class Solution {
    public void swap(int arr[], int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public int firstMissingPositive(int[] arr) {
        int n = arr.length;
        int i = 0;

        while(i<n){
            if (arr[i] > n || arr[i]<1 || arr[i]==arr[i]-1){
                i++;
                continue;
            }
            int idx = arr[i]-1;
            if(arr[i]==arr[idx]) i++;
            else swap(arr,i,idx);
        }

        for(int j=0;j<n;j++){
            if(j+1!=arr[j]){
                return j+1;
            }
        }

        return n+1;
    }
}