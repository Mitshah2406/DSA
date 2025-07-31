// User function Template for Java
class Solution {
    static int setKthBit(int n, int k) {
        // code here
        /*
    We are ORing the number with left shifted Kth number because 1 & anything or always yeild 1, 
    xor is not used because if the kth bit to be sit is already 1, then answer could be wrong
    
    TC = O(1), Sc = O(1)
    */
        return (n|(1<<k));
    }
}
