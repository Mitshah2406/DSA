//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Meeting implements Comparable<Meeting>{
    int id;
    int st;
    int end;
    
    
    public Meeting(int id, int st, int end){
        this.id = id;
        this.st=st;
        this.end=end;
        
    }
    
    @Override
    public int compareTo(Meeting m){
        return this.end-m.end;
    }
}
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        Meeting[] temp = new Meeting[n];
        for(int i=0;i<n;i++){
            temp[i] = new Meeting(i, start[i], end[i]);
        }
        int ans=0;
        Arrays.sort(temp);
        boolean hm[] = new boolean[1000001];
    
        for(int i=0;i<n;i++){
            int s = temp[i].st;
            int e = temp[i].end;
            
            
            if(!hm[s] && !hm[e]){
                boolean valid = true;
                for(int j=s;j<=e;j++){
                    if(hm[j]==true){
                        valid=false;
                        break;
                    }
                    hm[j] = true;
                }
                if(valid){
                    ans++;
                }
            }
        }
        
        return ans;
        
    }
}
