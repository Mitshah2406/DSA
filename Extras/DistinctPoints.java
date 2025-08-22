import java.io.*;
import java.util.*;

public class Solution {
    /*
    Time - O(n)
    Space - O(distinct) + O(N*3) (3 is length of string) * N times for N loops
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        
        for(int i=0;i<n;i++){
            arr1[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            arr2[i] = sc.nextInt();
        }
        HashSet<String> hs = new HashSet();
        int distinct = n;
        for(int i=0;i<n;i++){
            String s = "";
            s+=(arr1[i]+"_"+arr2[i]);
            if(hs.contains(s)){
                distinct--;
            }else{
                hs.add(s);
            }
        }
        System.out.println(distinct);
    }
}
