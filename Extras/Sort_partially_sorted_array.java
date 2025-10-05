import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int j = n-1;
        for(int i=n-1;i>=0;i--){
            int minIdx = i;
            int min = arr[i];
            

            if(min>=arr[j]){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                
                j = i;
            }
            
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
