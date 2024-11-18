class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        
        // Brute Force - O(n^2)
        // int n = arr.length;
        // ArrayList<Integer> ans = new ArrayList();
        
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[j]>arr[i]){
        //             ans.add(arr[j]);
        //             break;
        //         }
        //     }
        //     if(ans.size()!=i+1){
        //         ans.add(-1);
        //     }
        // }
        
        // return ans;
        
        // Optimal - 
            // TC- O(n) 
            // SC- O(n)
            
            // Iterate and if you can solve , then solve it the already existing in stack otherwise get pushed as a problem
        int n = arr.length;
        Stack<Integer> st = new Stack();
        int ans[] = new int[n];
        ArrayList<Integer> res = new ArrayList();
        for(int i=0;i<n;i++){
             while(st.size()>0 && arr[i]>arr[st.peek()]){
                int idx = st.pop();
                ans[idx] = arr[i];
            }

           st.push(i);
        }
        
        while(!st.isEmpty()){
            ans[st.pop()] = -1;
        }
        
        for(int i=0;i<n;i++){
            res.add(ans[i]);
        }
        return res;
    }
}