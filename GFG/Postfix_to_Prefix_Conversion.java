// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        Stack<StringBuilder> st = new Stack();
        
        for(int i=0;i<post_exp.length();i++){
            char curr= post_exp.charAt(i);
            
            if((curr>='a' && curr<='z') || (curr>='A' && curr<='Z') || (curr>='0' && curr<='1')){
                StringBuilder sb = new StringBuilder();
                sb.append(curr);
                st.push(sb);
            }else{
                 StringBuilder second =st.pop();
                 StringBuilder first =st.pop();
                 StringBuilder res = new StringBuilder();
                 res.append(curr);
                 res.append(first);
                 res.append(second);
                 st.push(res);
            }
        }
        return st.peek().toString();
    }
}
