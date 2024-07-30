class Solution {
    public int divide(int dividend, int divisor) {
        long sign = 1;
        long a = dividend;
        long b = divisor;

        if(a<0){ sign*=-1;}
        if(b<0){ sign*=-1;}
        System.out.println(sign);
        long temp = 0;
        long q = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        for(int i=31;i>=0;i--){
            if(temp+(b<<i)<=a){
                temp = temp+ (b<<i);
                q = q + ((long)1<<i);
            }
        }
        if(sign==-1){
                    System.out.println(sign);
            q*=-1;
        }
        if(q>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)q;

    }
}