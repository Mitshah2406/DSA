class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Brute (Time O(n^2))
        // int n = temperatures.length;
        // int ans[] = new int[n];
        // for(int i=0;i<n;i++){
        //     int curr = temperatures[i];
        //     for(int j=i+1;j<n;j++){
        //         if(temperatures[j]>curr){
        //             ans[i]=j-i;
        //             break;
        //         }
        //     }
        //     //else default is 0;
        // }

        // return ans;


        // Optimal - use Next greater on right 
        // Tc - O(n) with space

        Stack<Integer> st = new Stack();
        int n = temperatures.length;
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int toBeSolved = st.pop();
                ans[toBeSolved] = i-toBeSolved;
            }
            st.push(i);
        }
        return ans;
    }
}
