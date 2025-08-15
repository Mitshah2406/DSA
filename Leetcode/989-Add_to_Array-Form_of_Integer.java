class Solution {
    /**
    O(n), O(1)
    Intuition =
    We will reverse the array and perform the operations, so that last extra carry if added, we wont have to shift entire array which is O(n)
    So reversing the array, so we need to just append which is O(1) operation

    [2,1,5] k = 806, ans = 1021
    reverse the array = [5,1,2]

    6+5 = 11; [11,1,2] => [1,1,2] => carry=11/10=1, arr[i] = 11%10=1, k(806) = 806/10 = 80 + carry(1) = 81 [New K]
    1+1 = 2;  [1,2,2]
    8+2 = 10; [1,2,10] => [1,2,0] => carry=10/10=1, arr[i] = 10%10=0, k(8) = 8/10 = 0 + carry(1) = 0+1 = 1 [New K]
    1; [1,2,0,1]

    Now reverse [1,0,2,1]

     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(num[i]);
        }
        Collections.reverse(arr);
        int i = 0;
        while(k!=0){
            int digit = k % 10;
            if(i<n){
                arr.set(i, arr.get(i)+digit);    
            }else{
                arr.add(digit);
            }

            int carry = arr.get(i) / 10;
            arr.set(i, arr.get(i)%10);    

            k= k /10;
            k+=carry;
            i++;
        }

        Collections.reverse(arr);
        return arr;
    }
}