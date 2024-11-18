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
            
            // Iterate from backwards keep adding elems to stack and updates all ans
            // reverse the arr
        int n = arr.length;
        Stack<Integer> st = new Stack();
        ArrayList<Integer> ans = new ArrayList();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ans.add(-1);
            }else{
                ans.add(st.peek());
            }
            st.push(arr[i]);
        }
        
        Collections.reverse(ans);
        return ans;
    }
}