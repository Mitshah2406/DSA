class Solution {

    private void merge(int arr[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;

        int res[] = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                res[k] = arr[i];
                i++;
            } else {
                res[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            res[k] = arr[i];
            i++;
            k++;
        }

        while (j <= high) {
            res[k] = arr[j];
            j++;
            k++;
        }

        for (int m = 0; m < res.length; m++) {
            arr[low + m] = res[m];
        }
    }

    private void mergeSort(int arr[], int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);

    }

    private void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private void insertionSort(int arr[], int n) {

        // take every element backtrack in arr and insert that ele in correct pos
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private void selectionSort(int arr[], int n) {
        // pick min in every iteration and put at first
        for (int i = 0; i < n - 1; i++) {
            int min = arr[i];
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

        }
    }

    private int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int s = low + 1;
        int e = high;

        while (s <= e) {
            if (pivot > arr[s]) {
                s++;
            } else if (pivot <= arr[e]) {
                e--;
            } else {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        int temp = arr[low];
        arr[low] = arr[e];
        arr[e] = temp;

        return e;
    }

    private void quickSort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        int loc = partition(arr, low, high);

        quickSort(arr, low, loc - 1);
        quickSort(arr, loc + 1, high);

    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, nums.length - 1); // --> best
        // bubbleSort(nums, n); // --> gives tle

        // selectionSort(nums, n); // --> gives tle

        // insertionSort(nums, n); // gives tle
        // quickSort(nums, 0, nums.length - 1); // --> best but gives tle on last case
        return nums;
    }
}
