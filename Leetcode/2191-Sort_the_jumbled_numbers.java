class Jumbled implements Comparable<Jumbled> {
    int og;
    int derived;
    int i;

    public Jumbled(int o, int d, int i) {
        this.og = o;
        this.derived = d;
        this.i = i;
    }

    @Override
    public int compareTo(Jumbled j) {
        int ans = this.derived - j.derived;
        if (ans != 0) {
            return ans;
        }

        ans = this.i - j.i;
        return ans;
    }
}

class Solution {
    private int digitMapper(int mapping[], int num) {
        if (num >= 0 && num <= 9) {
            return mapping[num];
        }
        int ans = 0;
        int place = 1;
    
        while (num != 0) {
            int currMappedDigit = num % 10; 
            ans += mapping[currMappedDigit] * place; 
            num = num / 10; 
            place = place * 10; 
        }
        return ans;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
        Jumbled ans[] = new Jumbled[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            ans[i] = new Jumbled(num, digitMapper(mapping, num), i);
        }

        Arrays.sort(ans);
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i].og;
        }

        return nums;
    }
}
