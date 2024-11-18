class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // Optimal Approach - 
            // TC - O(n)
            // SC - O(n)

            // Idea
                // i and j pointers for both arrays
                // run a loop for 2n times 
                    // if st is empty and i<n just push
                    // else if top of st == popped[curr] then keep on popping
        int i = 0;
        int j = 0;
        int n = pushed.length;
        int ops = n + n;
        Stack<Integer> st = new Stack();
        int k = 0;
        while (k < ops) {
            if(i==n && j==n) break;
            while (st.size() > 0 && j < n && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
            if (i < n) {
                st.push(pushed[i]);
                i++;
            }
            k++;
        }

        return j == n && i == n;
    }
}