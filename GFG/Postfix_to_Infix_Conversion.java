// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        Stack<StringBuilder> st = new Stack();
        
        for(int i=0;i<exp.length();i++){
            char curr = exp.charAt(i);
            
            if((curr>='0' && curr<='9')|| (curr>='a' && curr<='z') || (curr>='A' && curr<='Z')){
                StringBuilder sb = new StringBuilder();
                sb.append(curr);
                st.push(sb);
            }else{
                StringBuilder second = st.pop();
                StringBuilder first = st.pop();
                StringBuilder res = new StringBuilder();
                res.append("(");
                res.append(first);
                res.append(curr);
                res.append(second);
                res.append(")");
                st.push(res);
            }
        }
        return st.peek().toString();
    }
}
