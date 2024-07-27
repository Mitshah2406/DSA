class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int len = arr.length+2;
        int dup[] = new int[len];
        for(int i=0;i<len-2;i++){
            dup[i+1]=arr[i];
          
        }
        for(int i=1;i<len-1;i++){
              if(n==0){
                break;
            }
            if(dup[i]==0){
                if(dup[i-1] ==0 && dup[i+1]==0){
                    n--;
                    dup[i]=1;
                }
            }
        }
        return n == 0;
    }
}