//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // prefix count of 0,1,2
        int p0 = 0;
        int p1= 0;
        int p2 = 0;
        int n = str.length();
        int ans = 0;
        
        HashMap<String,Integer> hm = new HashMap();
        hm.put("0@0",1);
        
        for(int i=0;i<n;i++){
            int ch = str.charAt(i) - '0';
            if(ch==0){
                p0++;
            }else if(ch==1){
                p1++;
            }else{
                p2++;
            }
            
            int diff1 = p0-p1;
            int diff2 = p0-p2;
            String t = diff1+"@"+diff2;
            ans += hm.getOrDefault(t, 0);
            
            hm.put(t, hm.getOrDefault(t, 0)+1);
            
        }
        
        return ans;
    }
} 