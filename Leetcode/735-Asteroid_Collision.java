class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            int curr = asteroids[i];
            if (st.size() > 0 && (st.peek() > 0 && curr < 0)) {
                // collide
                boolean isCurrPushed = false;
                while (st.size() > 0 && (st.peek() > 0 && curr < 0)) {
                    int first = Math.abs(st.peek());
                    int scd = Math.abs(curr);
                    if (first < scd) {
                        st.pop();
                        isCurrPushed = true;
                    } else if (first > scd) {
                        isCurrPushed = false;
                        break;
                    } else {
                        st.pop();
                        isCurrPushed = false;
                        break;
                    }
                }
                if (isCurrPushed)
                    st.push(curr);
            } else {
                st.push(curr);
            }
            // System.out.println(st);
        }
        int n1 = st.size();
        int ans[] = new int[n1];
        int it = n1 - 1;

        while (!st.isEmpty()) {
            ans[it] = st.pop();
            it--;
        }

        return ans;
    }
}