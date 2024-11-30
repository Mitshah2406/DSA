// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        Stack<StringBuilder> st = new Stack();
        
        for(int i=pre_exp.length()-1; i>=0; i--){
            char curr = pre_exp.charAt(i);
            
            
            if((curr>='0' && curr<='9')||(curr>='a' && curr<='z')||(curr>='A' && curr<='Z')){
                StringBuilder sb = new StringBuilder();
                sb.append(curr);
                st.push(sb);
            }else{
                StringBuilder f = st.pop();           
                StringBuilder s = st.pop();        
                StringBuilder res= new StringBuilder();
                res.append(f);
                res.append(s);
                res.append(curr);
                st.push(res);
            }
        }
        
        return st.peek().toString();
    }
}
