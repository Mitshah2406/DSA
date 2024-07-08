// Search in Rotated Sorted Array
// Difficulty: Medium
// Given a sorted (in ascending order) and rotated array arr of distinct elements which may be rotated at some point and given an element key, the task is to find the index of the given element key in the array arr. The whole array arr is given as the range to search.

// Rotation shifts elements of the array by a certain number of positions, with elements that fall off one end reappearing at the other end.

// Note:- 0-based indexing is followed & returns -1 if the key is not present.

// Examples :

// Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 10
// Output: 5
// Explanation: 10 is found at index 5.
// Input: arr[] = [3, 5, 1, 2], key = 6
// Output: -1
// Explanation: There is no element that has value 6.
// Expected Time Complexity: O(log n)
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 ≤ arr.size() ≤ 106
// 0 ≤ arr[i] ≤ 106
// 1 ≤ key ≤ 105
// Link -->  https://www.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
class Solution {
    public static int binarySearch(int[] arr, int n, int target){
        int left = 0;
        int right = n-1;
        
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(target==arr[mid]){
                return mid;
            }
            if(arr[mid]<=arr[right]){
                //right is sorted
                
                if(target>=arr[mid] && target<=arr[right]){
                    // checking in which part element exist
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                //left is sorted
                if(target<=arr[mid] && target>=arr[left]){
                     // checking in which part element exist
                   right  = mid-1;
                }else{
                     left = mid+1;
                }
            }
        }
        
        return -1;
    }
    int search(int[] arr, int key) {
       int n = arr.length;
       return binarySearch(arr, n, key);
       
    }
}


// TC - O(logn)
// SC - O(1)