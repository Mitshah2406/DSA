import java.util.* ;
import java.io.*; 
/*
Time - O(n^2)
Space - O(1)

Just consider i as min, and find min than i ahead, and swap them
*/
public class Solution {
	private static void swap(int arr[], int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	public static void selectionSort(int arr[], int n) {
		int min = 0;
		for(int i=0;i<n;i++){
			int minEle = arr[i];
			int minIdx = i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<=minEle){
					minEle = arr[j];
					minIdx = j;
				}
			}

			swap(arr, i, minIdx);
		}
	}
}
