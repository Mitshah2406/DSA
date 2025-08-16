// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // Simple Reverse Digit and keep adding the cubes of it and at last compare it
      // time = O(log10(n))
        int og = n;
        int sum = 0;
        while(n!=0){
            int d = n%10; // get last digit
            n = n/10; // prune the last digit
            sum+=(d*d*d);
        }
        
        return sum==og;
    }
}
