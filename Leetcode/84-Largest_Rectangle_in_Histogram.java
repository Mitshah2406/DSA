class Solution {
    public int largestRectangleArea(int[] ht) {

        // brute force
        // int maxHt = -1;
        // int n = heights.length;
        // for(int i=0;i<n;i++){
        // int minHt = 100001;
        // for(int j=i;j<n;j++){
        // minHt = Math.min(minHt, heights[j]);
        // maxHt = Math.max(maxHt, (j-i+1)*minHt);
        // }
        // }

        // return maxHt;

        // Optimal -
        // TC - O(3n)
        // SC - O(n)
        // int n = ht.length;

        // Stack<Integer> st = new Stack();

        // int nser[] = new int[n];
        // int nsel[] = new int[n];

        // for (int i = 0; i < n; i++) {
        // nser[i] = n;
        // while (!st.isEmpty() && ht[i] < ht[st.peek()]) {
        // int idx = st.pop();
        // nser[idx] = i;
        // }
        // st.push(i);
        // }
        // st.clear();
        // for (int i = n - 1; i >= 0; i--) {
        // nsel[i] = -1;

        // while (!st.isEmpty() && ht[i] < ht[st.peek()]) {
        // int idx = st.pop();
        // nsel[idx] = i;
        // }
        // st.push(i);
        // }
        // int maxArea = -1;
        // for(int i=0;i<n;i++){
        // int height = ht[i];
        // int x1 = nser[i]-1;
        // int x2 = nsel[i]+1;

        // int width = x1-x2+1;

        // maxArea = Math.max(maxArea, width*height);
        // }

        // return maxArea;

        // Most Optimal

        // TC - O(1n)
        // SC - O(n)

        Stack<Integer> st = new Stack();

        int n = ht.length;

        int res = -1;
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && ht[i] < ht[st.peek()]) {
                int toBeComputed = st.pop();
                int nse = i; // next smaller 
                int pse = 0; // previous small

                if (st.size() != 0) {
                    pse = st.peek();
                } else {
                    pse = -1;
                }

                int ans = ht[toBeComputed] * (nse - pse - 1);

                res = Math.max(res, ans);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int idx = st.pop();
            int x1 = n;
            int x2 = st.isEmpty() ? -1 : st.peek();
            res = Math.max(res, ht[idx] * (x1 - x2 - 1));
        }

        return res;
    }
}