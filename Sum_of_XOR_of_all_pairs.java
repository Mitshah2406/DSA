  // User function Template for Java

class Solution {

    // Function for finding maximum and value pair
    private boolean checkBit(int n, int k){
        return (n&(1<<k))!=0;
    }
    public long sumXOR(int arr[], int n) {
        long ans = 0;
        /*
            Always try individual bits when bit manipulation comes
            
            TC - O(32*N)
            As xor results true when bits differ;
            Zero Count * One Count = Total Pairs on that bit index
        */
        for(int i=0;i<32;i++){
            long zeroCount = 0;
            long oneCount = 0;
            
            for(int j=0;j<n;j++){
                if(checkBit(arr[j], i)){
                    oneCount++;
                }else{
                    zeroCount++;
                }
            }
            
            ans += (1L<<i) * (zeroCount*oneCount);
        }
        
        return ans;
    }
    
    
}
