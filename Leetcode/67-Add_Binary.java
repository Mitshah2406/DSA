class Solution {
    public String addBinary(String a, String b) {
        /*
        Linear Simulation
                        Result  Carry
        0 + 0           0       0
        0 + 1           1       0
        1 + 0           1       0
        1 + 1           0       1
        1 + 1 + 1       1       1
        
        Time Complexity = O(max(n,m))
        Space Complexity = O(max(n,m)+1) since only one extra bit
         */

        // StringBuilder sb = new StringBuilder();

        // int n = a.length();
        // int m = b.length();
        // int i = n - 1;
        // int j = m - 1;
        // boolean carry = false;
        // while (i >= 0 && j >= 0) {
        //     char first = a.charAt(i);
        //     char second = b.charAt(j);
        //     if (first == '0' && second == '0') {
        //         if (carry) {
        //             sb.append('1');
        //             carry = false;
        //         } else {
        //             sb.append('0');
        //         }
        //     } else if ((first == '0' && second == '1') || (first == '1' && second == '0')) {
        //         if (carry) {
        //             sb.append('0');
        //             carry = true;
        //         } else {
        //             sb.append('1');
        //             carry = false;
        //         }
        //     } else {
        //         if (carry) {
        //             sb.append('1');
        //         } else {
        //             sb.append('0');
        //         }
        //         carry = true;
        //     }
        //     i--;
        //     j--;
        // }

        // while (i >= 0) {
        //     if (carry) {
        //         if (a.charAt(i) == '0') {
        //             sb.append('1');
        //             carry = false;
        //         } else {
        //             sb.append('0');
        //             carry = true;
        //         }
        //     } else {
        //         sb.append(a.charAt(i));
        //     }
        //     i--;
        // }
        // while (j >= 0) {
        //     if (carry) {
        //         if (b.charAt(j) == '0') {
        //             sb.append('1');
        //             carry = false;
        //         } else {
        //             sb.append('0');
        //             carry = true;
        //         }
        //     } else {
        //         sb.append(b.charAt(j));
        //     }
        //     j--;
        // }
        // if (carry) {
        //     sb.append('1');
        //     carry = false;
        // }
        // return sb.reverse().toString();

        /*
        More Cleaner Code
        
         */

        StringBuilder sb = new StringBuilder();
        int n = a.length();
        int m = b.length();
        int i = n - 1;
        int j = m - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';

            sb.append(sum % 2); // result bit
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }
}

// 1010
// 1011
// -----
// 10101

// 11
// 01
// ---
// 100