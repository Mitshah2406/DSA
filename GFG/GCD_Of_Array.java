// User function Template for Java

class Solution {
    /*
    Time = O(nlogn)
    */
    public int gcd(int n, int arr[]) {
        if(n==1){
            return arr[0];
        }
        
        int res = arr[0];
        for(int i=1;i<n;i++){
            res = findGCDIterative(res,arr[i]);
        }
        
        return res;
    }
    /*
    findGCD() has time of O(log phi min(a,b))
    */
    private int findGCDRecursive(int a, int b){
        if(a==0){
            return b;
        }
        
        if(a>b){
            return findGCDRecursive(a%b,b);
        }else{
            return findGCDRecursive(b%a,a);
        }
    }
    // O(log phi min(a,b))
    private int findGCDIterative(int a, int b){
        while(a>0 && b>0){
            if(a>b){
                a = a%b;
            }else{
                b = b%a; 
            }
        }
        return a==0 ? b : a;
    }
}
