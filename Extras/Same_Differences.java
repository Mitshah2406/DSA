import java.util.*;
public class Solution{
    private static void brute(Scanner sc, int tc){
        while(tc--!=0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            
            int cnt = 0;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(arr[j]>arr[i]){
                        if(arr[j]-arr[i]==j-i){
                            cnt++;
                        }
                    }
                }
            }
            
            System.out.println(cnt);
        }
    }
    private static void optimal(Scanner sc, int tc){
        while(tc--!=0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            
            HashMap<Integer, Integer> hm = new HashMap<>();
            long cnt = 0;
            for(int i=0;i<n;i++){
                cnt+=hm.getOrDefault(arr[i]-i, 0);
                hm.put(arr[i]-i, hm.getOrDefault(arr[i]-i,0)+1);
            }
            
            System.out.println(cnt);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        // brute(sc, tc);
        optimal(sc,tc);
    }
}
