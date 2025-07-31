class Solution {
    /*
    Time Complexity = O(NlogN) +  O(N⋅log(max_distance))
                    [SORTING]   [binary search + feasibility check]
    SPACE = O(1)
    */
    private boolean checkIfPossible(int arr[],int n, int k, int minDist){
        int cows = 1;
        int last = arr[0];
        
        for(int i=1;i<n;i++){
            if(arr[i]-last>=minDist){
                cows++;
                last = arr[i];
            }
            
            if(cows==k){
                break;
            }
        }
        
        return cows==k;
    }
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 1; // standing on possible case
        int high = stalls[n-1]; // standing on not possible case
        // POLARITY in binary search, when both cross, they switch sides, 
        // so the ans is if initially high was not possible, 
        // then now it will be on possible side
        // so ans is high
        while(low<=high){
            int mid = low + (high - low) /2;
            
            if(checkIfPossible(stalls,n,k,mid)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return high;
    }
}
