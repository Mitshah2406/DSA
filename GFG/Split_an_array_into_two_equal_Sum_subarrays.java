class Solution {
    private static int[] pre(int arr[], int n){
        int pre[] = new int[n];
        pre[0] = arr[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1]+arr[i];
        }
        return pre;
    }
     private static int[] suf(int arr[], int n){
     int suf[] = new int[n];
        suf[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suf[i] = suf[i+1]+arr[i];
        }
           return suf;
    }
    
    public boolean canSplit(int arr[]) {
        // brute
        int n = arr.length;
        int p[] = pre(arr, n);
        int s[] = suf(arr, n);
        
              
        for(int i=0;i<n-1;i++){
            if(p[i]==s[i+1]){
                return true;
            }
        }
   
        return false;
    }
}