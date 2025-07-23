import java.util.*;
public class Solution {
    public static int find(int day, int prev, int points[][], int dp[][]){
        if(day==-1){
            return 0;
        }
        if(dp[day][prev+1]!=-1){
            return dp[day][prev+1];
        }
        int max = 0;
        for(int i=0;i<3;i++){
            if(prev==-1 || prev!=i){
               max = Math.max(max,points[day][i] + find(day-1, i, points,dp));
            }
        }
        return dp[day][prev+1] = max;
    }
    public static int ninjaTraining(int n, int points[][]) {
        // int dp[][] = new int[n][4];
        // for(int d[]:dp){  
        //     Arrays.fill(d,-1);
        // }
        // return find(n-1, -1, points, dp);

        // int dp[][] = new int[n+1][4];

        // for(int day=0;day<n;day++){
        //     for(int prev=-1;prev<3;prev++){
        //         int maxPoints = 0;
        //         for (int task = 0; task < 3; task++) {
        //             if (task != prev) {
        //                 int pointsToday = points[day][task];
        //                 int prevDayPoints = (day > 0) ? dp[day - 1][task + 1] : 0;
        //                 maxPoints = Math.max(maxPoints, pointsToday + prevDayPoints);
        //             }
        //         }
        //         dp[day][prev + 1] = maxPoints;
        //     }
        // }

        // return dp[n-1][0];


        // space optimal
        // int dp[][] = new int[n+1][4];
        int curr[] = new int[4];
        int last[] = new int[4];
        for(int day=0;day<n;day++){
            for(int prev=-1;prev<3;prev++){
                int maxPoints = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != prev) {
                        int pointsToday = points[day][task];
                        int prevDayPoints = (day > 0) ? last[task + 1] : 0;
                        maxPoints = Math.max(maxPoints, pointsToday + prevDayPoints);
                    }
                }
                curr[prev + 1] = maxPoints;
            }
            last=curr.clone();
        }

        return last[0];
    }
// | Approach                       | Time Complexity | Space Complexity | Efficient|
// | ------------------------------ | --------------- | ---------------- | ---------|
// | Recursive (no memo)            | O(2^n)          | O(n)             | No       |
// | Recursive + Memoization        | O(n)            | O(n)             | Yes      |
// | Bottom-up DP (Tabulation)      | O(n)            | O(n)             | Yes      |
// | Bottom-up DP (Space Optimized) | O(n)            | O(1)             | Best     |

}

// https://www.naukri.com/code360/problems/ninja-s-training_3621003
