class Solution {
    private void find(int i, int n, String s, List<String> arr, StringBuilder sb){
        if(i>=n){
            arr.add(sb.toString());
            return;
        }
        char curr = s.charAt(i);
        // if alphabet
        if(Character.isLetter(curr)){
            // two ways, one is Uppercase, other is LowerCase
            sb.append(Character.toUpperCase(curr));
            find(i+1, n ,s , arr, sb);
            sb.setLength(sb.length()-1);

            sb.append(Character.toLowerCase(curr));
            find(i+1, n ,s , arr, sb);
            sb.setLength(sb.length()-1);
        }else{
        // if digit 
            sb.append(curr);
            find(i+1, n ,s , arr, sb);
            sb.setLength(sb.length()-1);
        }



    }
    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        List<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        find(0,n,s,arr,sb);
        return arr;
    }
}