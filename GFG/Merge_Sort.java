// Merge Sort
// Difficulty: Medium
// Given an array arr[], its starting position l and its ending position r. Sort the array using merge sort algorithm.
// Example 1:

// Input:
// N = 5
// arr[] = {4 1 3 9 7}
// Output:
// 1 3 4 7 9
// Example 2:

// Input:
// N = 10
// arr[] = {10 9 8 7 6 5 4 3 2 1}
// Output:
// 1 2 3 4 5 6 7 8 9 10

// Your Task:
// You don't need to take the input or print anything. Your task is to complete the function merge() which takes arr[], l, m, r as its input parameters and modifies arr[] in-place such that it is sorted from position l to position r, and function mergeSort() which uses merge() to sort the array in ascending order using merge sort algorithm.

// Expected Time Complexity: O(nlogn) 
// Expected Auxiliary Space: O(n)

// Constraints:
// 1 <= N <= 105
// 1 <= arr[i] <= 105

//Link --> https://www.geeksforgeeks.org/problems/merge-sort/1?utm_source=gfg

class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         int b[] = new int[r-l+1];
         int i=l;
         int j = m+1;
         int k = 0;
         
         while(i<=m && j<=r){
             if(arr[i]<=arr[j]){
                 b[k] = arr[i];
                 i++;
             }else{
                  b[k] = arr[j];
                j++;
             }
             k++;
         }

            while(i<=m){
             b[k] = arr[i];
             i++;
             k++;
            }
   
            while(j<=r){
             b[k] = arr[j];
             j++;
             k++;
            }

         
         for(int f=0;f<b.length;f++){
             arr[l+f] = b[f];
         }
         
    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l==r) return;
            int mid = (l+r)/2;
            mergeSort(arr, l,mid);
            mergeSort(arr,mid+1,r);
            
            merge(arr,l,mid,r);
    }
}


// TC - O(nlogn)
// SC - O(n)