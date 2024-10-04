class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        if(n==2){
            return (long)skill[0]*skill[1];
        }
        Arrays.sort(skill);

        int st = 1;
        int end = n-2;
        long skillWt = skill[0]+skill[n-1];
        long chem = skill[0]*skill[n-1];
        while(st<end){
            int totalSkill = skill[st]+skill[end];
            if(skillWt==totalSkill){
                chem+=(skill[st]*skill[end]);
            }else{
                return -1;
            }
            st++;
            end--;
        }

        return chem;
    }
}