// User function Template for Java

class Solution {
    private void swap(int i, int j, int arr[]){
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        /*
        Fixed Size Sliding Window
        
        Intuition - 
        Here, we are told to find swaps required to group all numbers <=k together
        
        so we can define window length as count(nums<=k)
        
        then we can find bad numbers within each window,
        whatever is the minimum is the answer
        
        [2, 7, 9, 5, 8, 7, 4] k = 6, ws = 3
        
        2,7,9 = bad=2
        7,9,5 = bad=2
        9,5,8 = bad=2
        5,8,7 = bad=2
        8,7,4 = bad=2
        Here min bad numbers in any window is 2, so however you swap and group the numbers,
        atleast 2 swaps would be required to be done
        
        Time = O(N) + O(N)
        Space = O(1)
        */
        int n = arr.length;
        int ws = 0;
        for(int i:arr){
            if(i<=k) ws++;
        }
        
        int badNums = 0;
        int ans = ws;
        
        for(int i=0;i<ws;i++){
            if(arr[i]>k){
                badNums++;
            }
        }
        ans = badNums;
        
        for(int i=ws;i<n;i++){
            // remove prev window ele
            if(arr[i-ws]>k) badNums--;
            // add current window ele if it is bad
            if(arr[i]>k) badNums++;
            
            ans = Math.min(ans, badNums);
        }
        return ans;
    }
}
