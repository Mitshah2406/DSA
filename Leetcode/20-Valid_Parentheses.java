class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();

        char arr[] = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            char c = arr[i];

            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.size() > 0) {
                    char top = st.peek();
                    if ((c == ')' && top == '(') || (c == ']' && top == '[')
                            || (c == '}' && top == '{')) {

                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return st.size() == 0;
    }
}