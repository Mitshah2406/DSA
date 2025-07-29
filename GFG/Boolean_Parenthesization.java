// User function Template for Java
class Solution {
    static int find(int i, int j, int isTrue, String s, int dp[][][]){
        if(i>j){
            return 0;
        }
        if(i==j){
            if(isTrue==1){
                return s.charAt(i)=='T' ? 1 : 0;
            }else{
                return s.charAt(i)=='F' ? 1 : 0;
            }
        }
        if(dp[i][j][isTrue]!=-1){
            return dp[i][j][isTrue];
        }
        int ways = 0;
        for(int k=i+1;k<=j-1;k+=2){
            int lT = find(i,k-1,1,s,dp);
            int rT = find(k+1,j,1,s,dp);
            int lF = find(i,k-1,0,s,dp);
            int rF = find(k+1,j,0,s,dp);
            
            if(s.charAt(k)=='&'){
                // AND TRUTH TABLE
                // TT = T
                // FT = F
                // TF = F
                // FF = F
                if(isTrue==1){
                    ways += (lT*rT);
                }else{
                    ways+= (lT*rF) + (lF*rT) + (lF*rF);
                }
            }else if(s.charAt(k)=='|'){
                // OR TRUTH TABLE
                // TT = T
                // FT = T
                // TF = T
                // FF = F
                if(isTrue==1){
                    ways += (lT*rT) + (lF*rT) + (lT*rF);
                }else{
                    ways+= (lF*rF);
                }
            }else{
                // XOR TRUTH TABLE
                // TT = F
                // FT = T
                // TF = T
                // FF = F
                if(isTrue==1){
                    ways += (lF*rT) + (lT*rF);
                }else{
                    ways+= (lF*rF) + (lT*rT);
                }
            }
        }
        
        return dp[i][j][isTrue] = ways;
    }
    static int countWays(String s) {
        // code here
        // int n = s.length();
        // int dp[][][] = new int[n][n][2];
        // for(int d[][]:dp){
        //     for(int d1[]: d){
        //         Arrays.fill(d1,-1);
        //     }
        // }
        // return find(0,n-1,1,s,dp);
        
        
        int n = s.length();
        int dp[][][] = new int[n][n][2];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                for(int isTrue=1;isTrue>=0;isTrue--){
                    if(i==j){
                        if(isTrue==1){
                            dp[i][j][isTrue] = s.charAt(i)=='T' ? 1 : 0;
                        }else{
                            dp[i][j][isTrue] = s.charAt(i)=='F' ? 1 : 0;
                        }
                        continue;
                    }
                    int ways = 0;
                    for(int k=i+1;k<=j-1;k+=2){
                        int lT = dp[i][k-1][1];
                        int rT = dp[k+1][j][1];
                        int lF = dp[i][k-1][0];
                        int rF = dp[k+1][j][0];
                        
                        if(s.charAt(k)=='&'){
                            if(isTrue==1){
                                ways += (lT*rT);
                            }else{
                                ways+= (lT*rF) + (lF*rT) + (lF*rF);
                            }
                        }else if(s.charAt(k)=='|'){
                            if(isTrue==1){
                                ways += (lT*rT) + (lF*rT) + (lT*rF);
                            }else{
                                ways+= (lF*rF);
                            }
                        }else{
                            if(isTrue==1){
                                ways += (lF*rT) + (lT*rF);
                            }else{
                                ways+= (lF*rF) + (lT*rT);
                            }
                        }
                    }
                    
                    dp[i][j][isTrue] = ways;
                }
            }
        }
        
        return dp[0][n-1][1];
    }
    
    /*
    Intuition = Variant of MCM
    
    here we see we always have an operator at 1st indices and then at intervals of two, so we start k from i+1,to j-1
    f(0,n-1), so we always partition at an operator, and use truth table logics to count ways in falsy or truthy conditions
    
    // we need to count both false and truthy ways in order to solve this problem
    
    (MEMOIZATION)
    TIME COMPLEXITY  = O(N^2*2) * O(N) [partition loop] = O(N^3)
    SPACE COMPLEXITY = O(N^2*2) + O(N)
    
    (TABULATION)
    TIME COMPLEXITY  = O(N^2*2) * O(N) [partition loop] = O(N^3)
    SPACE COMPLEXITY = O(N^2*2)
    */
}
