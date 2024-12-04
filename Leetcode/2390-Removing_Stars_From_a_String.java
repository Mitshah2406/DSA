class Solution {
    public String removeStars(String s) {
        // Stack<Character> st = new Stack();

        // int n = s.length();

        // for(int i=0;i<n;i++){
        //     char curr = s.charAt(i);
        //     if(curr=='*'){
        //         st.pop();
        //     }else{
        //         st.push(curr);
        //     }
        // }

        // StringBuilder sb = new StringBuilder();

        // while(!st.isEmpty()){
        //     sb.append(st.pop());
        // }

        // return sb.reverse().toString();



        // optimal

        StringBuilder sb = new StringBuilder();

        int n = s.length();

        for(int i=0;i<n;i++){
            char curr = s.charAt(i);
            if(curr=='*'){
                sb.setLength(sb.length()-1);
            }else{
                sb.append(curr);
            }
        }

       return sb.toString();

    }
}