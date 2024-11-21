class Solution {
    public int maxHistogram(int arr[], int n) {
        Stack<Integer> st = new Stack();
        int maxArea = -1;
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int tbs = st.pop();
                int nser = i;
                int nsel = -1;
                if (!st.isEmpty()) {
                    nsel = st.peek();
                }
                int x1 = nser - 1;
                int x2 = nsel + 1;

                maxArea = Math.max(maxArea, arr[tbs] * (x1 - x2 + 1));
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            int tbs = st.pop();
            int nser = n;
            int nsel = -1;
            if (!st.isEmpty()) {
                nsel = st.peek();
            }
            int x1 = nser - 1;
            int x2 = nsel + 1;

            maxArea = Math.max(maxArea, arr[tbs] * (x1 - x2 + 1));
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int pSum[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        pSum[i][j] = 1;
                    } else {
                        pSum[i][j] = 1 + pSum[i - 1][j];
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int res = maxHistogram(pSum[i], m);
            ans = Math.max(ans, res);
        }
        return ans;
    }
}