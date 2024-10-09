class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack();
        int insertions = 0;
        char arr[] = s.toCharArray();
        int n = arr.length;
        for(int i=0;i<n;i++){
            char c = arr[i];

            if(c=='('){
                st.push(c);
            }else if(c==')' && st.size()>0){
                if(st.peek()=='('){
                    st.pop();
                }
            }else{
                insertions++;
            }
        }
        if(st.size()!=0){
            insertions+=st.size();
        }
        return insertions;
    }
}