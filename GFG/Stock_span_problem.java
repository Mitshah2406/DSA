class Solution {
    // Function to calculate the span of stock's price for all n days.
    public ArrayList<Integer> calculateSpan(int[] arr) {
        Stack<Integer> st = new Stack();
        // used Next greater on left
        int n = arr.length;
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                int popped = st.pop();
                ans[popped] = i;
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            ans[st.pop()] = -1;
        }
        ArrayList<Integer> res = new ArrayList();
        for(int i=0;i<n;i++){
            res.add(i-ans[i]);
        }
        
        return res;
    }
}