
/*
Method	            Time 	Space   Passes
Two-pointer swap	O(n)    O(1)    1
Counting method	    O(n)	O(1)    2
*/
class Solution {
    /*
    TLE (Brute)
    Time - O(n) + O(nZero+nOne);
    Space - O(1)
    */
    void brute(int arr[], int n){
        int ones = 0;
        
        for(int i:arr){
            ones+=i;
        }
        int zeros = n-ones;
        for(int i=0;i<zeros;i++){
            arr[i] = 0;
        }
        for(int i=zeros;i<n;i++){
            arr[i] = 1;
        }
    }
    
    /*
    Time - O(N), Space - O(1)
    One pass two ptr algo
    */
    void optimal(int arr[], int n){
        int i = 0;
        int j = n-1;
        
        while(i<j){
            if(arr[i]==0){
                i++; // left part is good
            }else if(arr[j]==1){
                j--; // right part is good
            }else{
                // Here 1,0 swap and move both
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }
    }
    void segregate0and1(int[] arr) {
        // code here
        int n = arr.length;
        
        // brute(arr,n);
        optimal(arr,n);
    }
}
