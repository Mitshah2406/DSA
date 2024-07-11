// Difficulty: Medium
// Given an array, arr of integers, and another number target, find three integers in the array such that their sum is closest to the target. Return the sum of the three integers.

// Note: If there are multiple solutions, return the maximum one.

// Examples :

// Input: arr[] = [-7, 9, 8, 3, 1, 1], target = 2
// Output: 2
// Explanation: There is only one triplet present in the array where elements are -7,8,1 whose sum is 2.
// Input: arr[] = [5, 2, 7, 5], target = 13
// Output: 14
// Explanation: There is one triplet with sum 12 and other with sum 14 in the array. Triplet elements are 5, 2, 5 and 2, 7, 5 respectively. Since abs(13-12) ==abs(13-14) maximum triplet sum will be preferred i.e 14.
// Expected Time Complexity: O(n2)
// Expected Auxiliary Space: O(1)

// Constraints:
// 3 ≤ arr.size() ≤ 103
// -105 ≤ arr[i] ≤ 105
// 1 ≤ target ≤ 105

//Link --> https://www.geeksforgeeks.org/problems/three-sum-closest/1
class Solution {
    static int threeSumClosest(int[] arr, int target) {
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


// TC - O(n)
// SC - O(1)