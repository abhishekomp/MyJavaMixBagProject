package apnacollege.sorting.bubblesort;

//https://www.youtube.com/watch?v=PkJIc5tBRUE&list=PLfqMhTWNBTe0gqgFk-CUE-ktO5Cek1GdP&index=16
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 3, 2};
//        int[] arr = {1, 8, 7, 3, 2};
//        int[] arr = {5, 9, 7, 8, 4, 1, 3, 2, 6};
        printArray(arr, "Given Array");
        System.out.println("Running bubble sort");
        bubbleSort(arr);
        printArray(arr, "Sorted Array");
    }

    //Time complexity = O(n^2)
    private static void bubbleSort(int[] arr) {
        int loopCnt = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            loopCnt++;
            for(int j = 0; j < arr.length - i - 1; j++) {
                loopCnt++;
                swapAscending(arr, j);
//                swapDescending(arr, j);
            }
//            printArray(arr, "After pass = " + Integer.toString(i + 1));
        }
        System.out.println("loopCnt = " + loopCnt);
    }

    private static void swapAscending(int[] arr, int j) {
        if(arr[j] > arr[j +1]) {
            int temp = arr[j];
            arr[j] = arr[j +1];
            arr[j +1] = temp;
        }
    }

    private static void swapDescending(int[] arr, int j) {
        if(arr[j] < arr[j +1]) {
            int temp = arr[j];
            arr[j] = arr[j +1];
            arr[j +1] = temp;
        }
    }

    private static void printArray(int[] arr, String msg) {
        System.out.println(msg);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
