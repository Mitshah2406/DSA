class Solution {
    public String removeOccurrences(String s, String part) {
        // Approach Time Complexity Space Complexity
        // Brute Force O(n⋅k) O(n)
        // Optimal O(n) O(n)

        // Brute Force
        // Stack<Character> st = new Stack();
        // int n = s.length();
        // int searchStrLen = part.length();
        // for(int i=0;i<n;i++){
        // char curr = s.charAt(i);
        // if(curr==part.charAt(searchStrLen-1)){
        // int j = searchStrLen-2;
        // StringBuilder sb = new StringBuilder();
        // while(!st.isEmpty() && j>=0 && part.charAt(j)==st.peek()){
        // sb.append(st.pop());
        // j--;
        // }

        // if(j>=0){
        // sb = sb.reverse();
        // for(int k=0;k<sb.length();k++){
        // st.push(sb.charAt(k));
        // }
        // st.push(curr);
        // }
        // }else{
        // st.push(curr);
        // }
        // }

        // StringBuilder res = new StringBuilder();
        // while(!st.isEmpty()){
        // res.append(st.pop());
        // }
        // return res.reverse().toString();

        // Optimal

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int k = part.length();
        if (k > n) {
            return s;
        }

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            sb.append(curr);

            while (sb.length() >= k && sb.substring(sb.length() - k, sb.length()).equals(part)) {
                sb.setLength(sb.length() - k);
            }
        }

        return sb.toString();
    }
}
