import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    private static long brute(ArrayList<Integer> nums, int n, int k){
        long sum = 0;
        for(int i=0;i<n;i++){
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            for(int j=i;j<n;j++){
                max = Math.max(max, nums.get(j));
                min = Math.min(min, nums.get(j));
                if(j-i+1==k){
                    sum += (min+max);
                    break;
                }
            }
        }
        return sum;
    }

    private static long optimal(ArrayList<Integer> nums, int n, int k){
        long sum = 0;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        int maxIdx = -1, minIdx = -1;


        for(int i=0;i<k;i++){
            if(max<nums.get(i)){
                max = nums.get(i);
                maxIdx = i;
            }
            if(min>nums.get(i)){
                min = nums.get(i);
                minIdx = i;
            }
        }

        sum += (max+min);

        for(int i=k;i<n;i++){
            // remove i-k
            if(i-k == minIdx || i-k ==maxIdx){
                // recalculate window
                max = Long.MIN_VALUE;
                min = Long.MAX_VALUE;
                for(int w=i-k+1;w<=i;w++){
                    if(max<nums.get(w)){
                        max = nums.get(w);
                        maxIdx = w;
                    }
                    if(min>nums.get(w)){
                        min = nums.get(w);
                        minIdx = w;
                    }
                }
            }else{
                if(max<nums.get(i)){
                    max = nums.get(i);
                    maxIdx = i;
                }
                if(min>nums.get(i)){
                    min = nums.get(i);
                    minIdx = i;
                }
            }
            // add i

            sum+=(min+max);
        }
        return sum;
    }
    public static long sumOfMaxAndMin(ArrayList<Integer> nums, int n, int k) {
        return optimal(nums,n,k);
    }
}
