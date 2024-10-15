class Solution {
    public int[] twoSum(int[] arr, int target) {

        int n = arr.length;
        int ans[] = new int[2];
        // brute - O(n^2)
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i]+arr[j]==target){
        //             ans[0] = i;
        //             ans[1] = j;
        //             return ans;
        //         }
        //     }
        // }
        // return ans;

        // better - O(n) with space

        HashMap<Integer, Integer> hm = new HashMap();

        for(int i=0;i<n;i++){
            if(hm.containsKey(target-arr[i])){
                ans[0]=i;
                ans[1] = hm.get(target-arr[i]);
                break;
            }
            hm.put(arr[i], i);
        }

        return ans;

       
    }
}