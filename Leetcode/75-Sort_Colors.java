class Solution {
    public void sortColors(int[] nums) {
        /**
        Brute - O(nlogn) [using sorting]
        Better - 2 pass O(n)
         */
        // int n = nums.length;
        // int zero=0;   
        // int one=0;   
        // int two=0;  
        // for(int i=0;i<n;i++){
        //     if(nums[i]==0) zero++;
        //     else if(nums[i]==1) one++;
        //     else two++;
        // } 

        // for(int i=0;i<n;i++){
        //     if(zero>0){
        //         nums[i]=0;
        //         zero--;
        //     }else if(one>0){
        //         nums[i]=1;
        //         one--;
        //     }else{
        //         two--;
        //         nums[i]=2;
        //     }
        // }

        /**
        Optimal - Dutch National flag - three equal sized color strips [Inspiration]
        Time - O(N), Space - O(1)
        Intuition - 
        
        Algo says we use three ptrs - (i,j,k)
        
        0..i-1 will have all 0's {Extreme Left}
        i to j-1 will have all 1's {Mid}
        high+1 to n-1 will have all 2's {Extreme Right}
        
        
        0000011111......22222
             i    j    k
        
        Here, we have to sort the j to k part which is unsorted
        so, if arr[j]==1, that means it is already sorted, we have been told j should contain unsorted ele
        so do j++
        if arr[j]==0, that means it is not sorted, we need to place 0 at its correct pos, we know that 0..i-1 are all 0's, then i..j-1 are 1's, so we can swap i and j, move both one step forward, so we maintain the rules for ranges
        swap(i,j)
        i++; j++;
        
        if arr[j]==2, that means it is not sorted, we need to place 2 at its correct pos, we know that k+1 to n-1 are all 2's, then j..k-1 are unsorted, so we can swap j and k, so , move both one step forward, so we maintain the rules for ranges
        swap(i,j)
        i++; j++;
         */
        int n = nums.length;
        int i = 0, j = 0, k = n-1;
        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else {
                swap(nums, j, k);
                k--;
            }
        }
    }

    private void swap(int arr[], int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }
}