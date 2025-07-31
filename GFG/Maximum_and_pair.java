class Solution {
    public int checkBit(int n, int k){
        if((n&(1<<k))==0){
            return 0;
        }
        
        return 1;
    }
    public int maxAND(List<Integer> arr) {
        // code here
        int n = arr.size();
        int sum[] = new int[32];
        

        for(int j=31;j>=0;j--){
           int c = 0;
           for(int i=0;i<n;i++){
               c+=checkBit(arr.get(i),j);
           }
           if(c>=2){
               // eliminate 0 eles
               
               for(int i=0;i<n;i++){
                   if(checkBit(arr.get(i),j)==0){
                       arr.set(i,0);
                   }
               }
           }
        }
        int a = -1;
        int b = -1;
        
        for(int i=0;i<n;i++){
            if(arr.get(i)>0){
                if(a==-1){
                    a = arr.get(i);
                }else if(b==-1){
                    b = arr.get(i);
                    break;
                }
            }
        }
        return a!=-1 && b!=-1 ? a&b : 0;
    }
}
