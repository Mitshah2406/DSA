// User function Template for Java
class Solution {
    /*
 Intuition:
 
 We want substrings where 0s, 1s, and 2s occur equally often.
 A direct way would be to try all substrings and count, but that's O(n^2).

 Trick:
 Instead of tracking counts separately, we look at the *differences*:
   - (count1 - count0)
   - (count2 - count1)
 Why?
 Because if two prefixes have the same differences, then the substring
 between them must have equal numbers of 0, 1, and 2.

 Example: 
   Say prefix up to i gives (x, y) and prefix up to j gives (x, y) again.
   Then from i+1 to j, the extra 0s, 1s, 2s added are balanced.

 We use a HashMap to store how many times each (diff1, diff2) pair
 has been seen so far. When we see the same key again, it means we
 can form substrings ending here with equal 0,1,2 counts.

 Important detail:
   We initialize the map with key "0#0" = 1 (empty prefix),
   so substrings starting at index 0 are also counted.

 Time Complexity:
   - O(n), since we scan the string once and do O(1) work per character.

 Space Complexity:
   - O(n) in the worst case, because the map can store up to n different
     difference pairs (though usually much less in practice).
*/

    long getSubstringWithEqual012(String str) {
        // code here
        int n = str.length();
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        
        int cnt0 = 0, cnt1 =0, cnt2 = 0;
        String key = (cnt1-cnt0)+"#"+(cnt2-cnt1);
        hm.put(key, 1);
        long ans = 0;
        
        for(int i=0;i<n;i++){
            char curr = str.charAt(i);
            if(curr=='0'){
                cnt0++;
            }else if(curr=='1'){
                cnt1++;
            }else{
                cnt2++;
            }
            
            String newKey = (cnt1-cnt0)+"#"+(cnt2-cnt1);
            if(hm.containsKey(newKey)){
                ans+=hm.get(newKey);
                hm.put(newKey, hm.get(newKey)+1);
            }else{
                hm.put(newKey,1);
            }
            
        }
        return ans;
    }
}
