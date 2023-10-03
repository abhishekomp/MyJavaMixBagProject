package apnacollege.sorting.bubblesort.usingStrategy;

public class AscendingSort implements SortingBehaviour {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                swapAscending(arr, j);
            }
        }
    }

    private static void swapAscending(int[] arr, int j) {
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
