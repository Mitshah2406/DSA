class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i / 2] + (i % 2); // (odd number adds one bit)
        }

        return arr;
    }
}

/*
Double (1 --> 2 --> 4)
--> 5 --> 10
(101) --> (1010) (1 bit shift but has same amount of bits)
(odd num (bit +1 from prev))
0  = 0000 = 0
1  = 0001 = 1
2  = 0010 = 1
3  = 0011 = 2
4  = 0100 = 1
5  = 0101 = 2
6  = 0110 = 2
7  = 0111 = 3
8  = 1000 = 1
9  = 1001 = 2
10 = 1010 = 2
11 = 1011 = 3
12 = 1100 = 2
13 = 1101 = 3
14 = 1110 = 3
15 = 1111 = 3
 */