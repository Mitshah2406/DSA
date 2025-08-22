import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*
        Find No of distincts in array
        Time - O(N), Space - O(distinct) [Using Hashset]
        */
        HashSet<Integer> hs = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int distinct = n;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            if(hs.contains(arr[i])){
                distinct--;
            }else{
                hs.add(arr[i]);
            }
        }
        System.out.println(distinct);
    }
}
