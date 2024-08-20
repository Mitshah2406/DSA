//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
            
            HashMap<Integer, Integer> hm = new HashMap();
            int p0 = 0; // prefix count of 0
            int p1=0; // prefix count of 1
            // you could also take an array of prefixes instead
            int ans = 0;
            hm.put(0,1);
            for(int i=0;i<n;i++){
                if(arr[i]==0){
                    p0++;
                }else{
                    p1++;
                }
                int diff = p0-p1;
                
               ans+= hm.getOrDefault(diff, 0);
               
               hm.put(diff,hm.getOrDefault(diff, 0)+1);
            }
            
            return ans; 
    }
}


