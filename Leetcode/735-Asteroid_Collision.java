class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> st = new Stack();

        int n = a.length;
        for (int i = 0; i < n; i++) {
            int as = a[i];
            boolean isFirstDestroyed = false;
            while (st.size() > 0 && (as < 0 && st.peek() > 0)) { // colliding
                int first = Math.abs(as);
                int scd = Math.abs(st.peek());

                if (first == scd) {
                    isFirstDestroyed = true;
                    st.pop();
                    break;
                } else if (first < scd) {
                    isFirstDestroyed = true;
                    break;
                } else {
                    st.pop();
                }
            }
            if (!isFirstDestroyed) {
                st.push(as);
            }

            

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