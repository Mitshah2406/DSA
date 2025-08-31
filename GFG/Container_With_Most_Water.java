class Solution {
    public int maxWater(int arr[]) {
        /*
            => Brute
            Time - O(n^2)
            Space - O(1)
            Run nested loop, try all pairs, keep the max as answer
            
            =>Optimal Approach
            Time - O(n)
            Space - O(1)
            Two Ptr approach, just keep pruning the min ptr
        */
        int n = arr.length;
        if(n==1) return 0; // One line cannot form a container
        int left = 0;
        int right = n-1;
        int ans = 0;
        while(left<right){ // till left and right arent equal
            // Min Container Wall * Width
            ans = Math.max(ans, Math.min(arr[left],arr[right])*(right-left));
            
            
            // Prune the min(left,right)
            if(arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}

