class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String str : strs){
            int count[] = new int[26];
            for(char c: str.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i: count){
                sb.append("#");
                sb.append(i);
            }
            String key = sb.toString();
            if(!hm.containsKey(key)){
                List<String> temp = new ArrayList();
                hm.put(key, temp);
            }
            hm.get(key).add(str);
        }

        return new ArrayList(hm.values());
    }
}