class Solution
{
    //Function to evaluate a postfix expression.
    public static int eval(char operator, int f, int s){
        if(operator=='+'){
            return f+s;
        }else if(operator=='-'){
            return f-s;
        }else if(operator=='*'){
            return f*s;
        }else{
            return f/s;
        }
    }
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> st = new Stack();
        
        for(int i=0;i<S.length();i++){
            char curr = S.charAt(i);
            
            if(curr>='0' && curr<='9'){
                st.push(curr-'0');
            }else{
                int second = st.pop();
                int first = st.pop();
                int res = eval(curr, first, second);
                
                st.push(res);
            }
        }
        return st.peek();
    }
}