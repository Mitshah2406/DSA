// Difficulty: Hard
// You are given an array consisting of n integers which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. You are given the task of assigning stalls to k cows such that the minimum distance between any two of them is the maximum possible.
// The first line of input contains two space-separated integers n and k.
// The second line contains n space-separated integers denoting the position of the stalls.

// Example 1:

// Input:
// n=5 
// k=3
// stalls = [1 2 4 8 9]
// Output:
// 3
// Explanation:
// The first cow can be placed at stalls[0], 
// the second cow can be placed at stalls[2] and 
// the third cow can be placed at stalls[3]. 
// The minimum distance between cows, in this case, is 3, 
// which also is the largest among all possible ways.
// Example 2:

// Input:
// n=5 
// k=3
// stalls = [10 1 2 7 5]
// Output:
// 4
// Explanation:
// The first cow can be placed at stalls[0],
// the second cow can be placed at stalls[1] and
// the third cow can be placed at stalls[4].
// The minimum distance between cows, in this case, is 4,
// which also is the largest among all possible ways.
// Your Task:
// Complete the function int solve(), which takes integer n, k, and a vector stalls with n integers as input and returns the largest possible minimum distance between cows.

// Expected Time Complexity: O(n*log(10^9)).
// Expected Auxiliary Space: O(1).

// Constraints:
// 2 <= n <= 10^5
// 2 <= k <= n
// 0 <= stalls[i] <= 10^9


//Link --> https://www.geeksforgeeks.org/problems/aggressive-cows/0
class Solution {
    public static int countCows(int stalls[], int mid){
        int sum=0;
        int ans = 1;
        int latestCow=stalls[0];
        for(int t=1;t<stalls.length;t++){
            if(Math.abs(latestCow-stalls[t])>=mid){
                latestCow = stalls[t];
                ans++;
            }
            
        }
        return ans;
    }
    public static int solve(int n, int k, int[] stalls) {
Arrays.sort(stalls);
        int minAns = Integer.MAX_VALUE;
        int maxAns =Math.abs(stalls[n-1]-stalls[0]);
        
        for(int i=1;i<n;i++){
            minAns = Math.min(minAns, Math.abs(stalls[i-1]-stalls[i]));
        }
        
        int high = maxAns;
        int low= minAns;
        int ans=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            int cowsPlaced=countCows(stalls, mid);
            
            
            if(cowsPlaced>=k){
                ans = mid;
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}


// TC - O(log(high-low)*n)
// SC -O(1)