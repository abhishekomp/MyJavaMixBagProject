package apnacollege.sorting.usingStrategyPattern;

public class ArrayPrinter {

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] arr, String msg) {
        System.out.println(msg);
        printArray(arr);
    }
}
