class Solution {
    public int calc(String op, int a, int b){
        if(op.equals("+")){
            return a+b;
        }else if(op.equals("-")){
            return a-b;
        }else if(op.equals("*")){
            return a*b;
        }else{
            return a/b;
        }
    }
    public boolean isInteger(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (Exception e) {
        return false;
    }
}
    public int evalRPN(String[] tokens) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        int n = tokens.length;
        Stack<Integer> st = new Stack();
        // just evaluate coz it is postfix so precedence is already taken careof
        for(int i=0;i<n;i++){
            boolean isInt = isInteger(tokens[i]);

            if(isInt){
                st.push(Integer.parseInt(tokens[i]));
            }else{
                int scd = st.pop();
                int first = st.pop();

                int res = calc(tokens[i], first,scd);
                st.push(res);
            }
        }
        return st.peek();
    }
}