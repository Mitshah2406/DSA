// User function Template for Java

class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        
        // Brute Force
        // int n = arr.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i]+arr[j]==target){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        // Better(1) - O(n) with O(n) space
        
        // HashSet<Integer> hs = new HashSet();
        // int n = arr.length;
        // for(int i=0;i<n;i++){
        //     if(hs.contains(target-arr[i])){
        //         return true;
        //     }
        //     hs.add(arr[i]);
        // }
        // return false;
        
        
        // Better O(nlogn) without space
        
        int n = arr.length;
        Arrays.sort(arr);
        int st = 0;
        int end=n-1;
        
        while(st<end){
            int sum = arr[st]+arr[end];
            if(sum==target){
                return true;
            }else if(sum<target){
                st++;
            }else{
                end--;
            }
        }
        return false;
        
    }
}