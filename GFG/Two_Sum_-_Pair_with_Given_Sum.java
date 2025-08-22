class Solution {
    /*
    Time - O(n^2), Space - O(1)
    */
    private boolean brute(int arr[], int n, int target){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target) return true;
            }
        }
        return false;
    }
    
    /*
    a+b=target
    b = target - a
    Keep a hashset, check if target-arr[i] is in Hashset, if there return
    or add and move further
    Time - O(n), Space - O(n)
    */
    private boolean better(int arr[], int n, int target){
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0;i<n;i++){
            if(hs.contains(target-arr[i])){
                return true;
            }
            hs.add(arr[i]);
        }
        
        return false;
    }
    /*
    We can sort the array and use two ptr technique
    Keep i at 0, j at n-1,
    if sum of (i,j) > target, we need to decrease the sum which means j--
    else, increase the sum, which means i++
    Time - O(nlogn) + O(n), Space - O(1)
    */
    private boolean optimal(int arr[], int n, int target){
        Arrays.sort(arr);
        
        int i = 0; 
        int j = n-1;
        
        while(i<j){
            int sum = arr[i]+arr[j];
            if(sum==target) return true;
            if(sum<target){
                i++;
            }else{
                j--;
            }
        }
        
        return false;
    }
    boolean twoSum(int arr[], int target) {
        // code here
        int n = arr.length;
        
        if(n<2) return false;
        
        // return brute(arr,n,target);
        // return better(arr,n,target);
        return optimal(arr,n,target);
    }
}
