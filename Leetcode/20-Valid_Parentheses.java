class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();

        Stack<Character> st = new Stack();

        for(int i=0;i<n;i++){
            char curr = arr[i];

            if(curr=='(' || curr=='[' || curr=='{'){
                st.push(curr);
            }else{
                if(st.size()!=0){
                    if(
                        (curr==')' && st.peek()=='(') ||
                        (curr==']' && st.peek()=='[') ||
                        (curr=='}' && st.peek()=='{') 
                    ){
                        st.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }

        return st.size()==0;
    }
}