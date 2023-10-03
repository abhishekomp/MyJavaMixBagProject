package apnacollege.sorting.insertionsort;

public class InsertionSort {
    //Time complexity = O(n^2)
    public void sortAscending(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] =current;
        }
    }

    public void sortDescending(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current > arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] =current;
        }
    }

    private static void printArray(int[] arr, String msg) {
        System.out.println(msg);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 3, 2};
//        int[] arr = {7, 1, 5, 3, 2};

//        InsertionSort insertionSortAsc = new InsertionSort();
//        printArray(arr, "Before Insertion sort");
//        insertionSortAsc.sortAscending(arr);
//        printArray(arr, "After Insertion sort");

        InsertionSort insertionSortDesc = new InsertionSort();
        printArray(arr, "Before Insertion sort");
        insertionSortDesc.sortDescending(arr);
        printArray(arr, "After Insertion sort in Descending Order");
    }
}
