// Medium

// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.

 

// Example 1:

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:

// Input: nums = [2,0,1]
// Output: [0,1,2]
 

// Constraints:

// n == nums.length
// 1 <= n <= 300
// nums[i] is either 0, 1, or 2.
 

// Follow up: Could you come up with a one-pass algorithm using only constant extra space?

//Link --> https://leetcode.com/problems/sort-colors/description/

//Soln - (two/three pointers) OR Dutch National Flag Algo (consists of three colors)
class Solution {
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void sortColors(int[] arr) {
        int n = arr.length;
        int i=0;
        int j=0;
        int k=n-1;

        while(j<=k){
            if(arr[j]==0){
                swap(arr, i,j);
                i++;
                j++;
            }else if(arr[j]==1){
                j++;
            }else{
                swap(arr, j,k);
                k--;
            }
        }
    }
}

// TC - O(N)
// SC - O(1)