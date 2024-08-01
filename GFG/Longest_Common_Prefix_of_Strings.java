//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        String least = arr[0];
        int n = arr.length;
        for(int i=1;i<n;i++){
            if(least.length()>arr[i].length()){
                least=arr[i];
            }
        }
        // System.out.println("Least"+least);
        // char toMatch[] = least.toCharArray();
        for(String s: arr){
            // System.out.println(s);
            for(int j=0;j<least.length() && j<s.length();j++){
                if(least.charAt(j)!=s.charAt(j)){
                // System.out.println("In"+j);
                    if(j==0){
                        least="";
                    }else{
                        // System.out.println(toMatch.length+" ->"+j);
                        least = least.substring(0,j);
                    }
                        break;
                }
            }
        }
        return (least.equals("") == true ? "-1" : least);
    }
}