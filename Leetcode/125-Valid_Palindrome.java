class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        char arr[] = s.toLowerCase().toCharArray();

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<n){
            if((arr[i]>='a' && arr[i]<='z') || (arr[i]>='0' && arr[i]<='9')){
                sb.append(arr[i]);
            }
            i++;
        }

        int st = 0;
        int len = sb.length();
        int end = len-1;

        while(st<=end){
            if(sb.charAt(st)!=sb.charAt(end)){
                return false;
            }

            st++;
            end--;
        }
        return true;
    }
}