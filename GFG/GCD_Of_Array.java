class Solution {
    public int findGcd(int dividend, int divisor){
        if(divisor==0){
            return dividend;
        }
        int res = findGcd(divisor, dividend%divisor);
        return res;
    }
    public int gcd(int n, int arr[]) {

        if(n==1){
            return arr[0];
        }
        int res = findGcd(arr[0], arr[1]);
        
        for(int i=1;i<n;i++){
            res = findGcd(res, arr[i]);
        }
        
        return res;
    }
}
