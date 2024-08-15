class Solution {
    public boolean lemonadeChange(int[] bills) {
        int arr[] = new int[5];
        int i=0;
        for(int n: bills){
            arr[n/5]++;
            int chng = n - 5;
            if(chng==0) continue;
             if (chng == 5) {
                int available = arr[chng/5];
                if (available > 0) {
                    arr[chng/5]--;
                    continue;
                }
            } else if(chng==15){
                int a5 = arr[5/5];
                int a10 = arr[10/5];
                if (a5 >= 1 && a10 >= 1) {
                    arr[5/5]--;
                    arr[10/5]--;
                    continue;
                } else if (a5 >= 3) {
                   arr[5/5]-=3;
                   continue;
                }
            }

            return false;

        }
        return true;
    }
}
