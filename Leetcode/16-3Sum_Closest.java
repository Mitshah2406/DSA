// Medium

// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.

 

// Example 1:

// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// Example 2:

// Input: nums = [0,0,0], target = 1
// Output: 0
// Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

// Constraints:

// 3 <= nums.length <= 500
// -1000 <= nums[i] <= 1000
// -104 <= target <= 104

//Link --> https://leetcode.com/problems/3sum-closest/description/


class Solution {
    public int threeSumClosest(int[] arr, int target) {
          int n = arr.length;
        boolean exactMatch=false;

     
        Arrays.sort(arr);
        int closestTarget = arr[0]+arr[1]+arr[2];
        
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j= i+1;
            int k = n-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                int prevDiff = Math.abs(target-closestTarget);
                int currDiff = Math.abs(target-sum);
                
                if(currDiff < prevDiff){
                    closestTarget = sum;
                }else if(currDiff == prevDiff){
                    closestTarget = Math.max(closestTarget, sum);
                }
                if(sum<target){
                    j++;
                }
                else if(sum>target){
                    k--;
                }
                else{
                   return sum;
                }
            }
            
        }
        
        return closestTarget;
    }
}

// TC - O(n^2)
// SC - O(1)