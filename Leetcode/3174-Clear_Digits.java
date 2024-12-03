class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack();
        int n = s.length();

        // Just push alphabets in stack and pop one when a digit arrives (as per problem defn)

        // then empty the stack in StringBuilder and reverse it
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                st.pop();
            } else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}