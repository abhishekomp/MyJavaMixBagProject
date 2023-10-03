package apnacollege.sorting.bubblesort.usingStrategy;

public class SortingClient {
    public static void main(String[] args) {
        //int[] arr = {7, 8, 1, 3, 2};
        int[] arr = {4, 6, 5, 7, 8, 1, 3, 2, 9};
        printArray(arr, "Given Array");

//        final int[] ascendingArray = new SortArray().sortArray(arr, new AscendingSort());
//        printArray(ascendingArray, "Sorted Ascending Array");

        new SortArray().sortArray(arr, new AscendingSort());
        printArray(arr, "Sorted Ascending Array");

        new SortArray().sortArray(arr, new DescendingSort());
        printArray(arr, "Sorted Ascending Array");

//        final int[] descendingArray = new SortArray().sortArray(arr, new DescendingSort());
//        printArray(descendingArray, "Sorted Descending Array");

    }
    private static void printArray(int[] arr, String msg) {
        System.out.println(msg);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
