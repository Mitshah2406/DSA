class CheckBit {
    /*
    Intuition = 1010 (10)
    check 1st idx bit
    
    0001 (1) << k(1) = 0010 &(logical and) 1010 = all other bits will naturally give zero, 
    the kth bit will depend, and if doesnt yield 0 the overall reult wont be zero
    
    thus, bit is set
    
    TC = O(1), SC = O(1)
    */
    static boolean checkKthBit(int n, int k) {
        // code here
        if((n&(1<<k))==0){
            return false;
        }
        return true;
    }
}
