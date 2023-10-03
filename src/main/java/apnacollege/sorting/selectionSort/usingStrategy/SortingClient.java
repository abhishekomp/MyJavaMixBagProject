package apnacollege.sorting.selectionSort.usingStrategy;

public class SortingClient {
    public static void main(String[] args) {

        //int[] arr = {7, 8, 1, 3, 2};
        int[] arr = {7, 8, 1, 3, 2, 6, 4, 5};

        final SelectionSort selectionSortAscending = new SelectionSort(new AscendingSort());
        selectionSortAscending.printArray(arr, "Before sorting in ascending order using Selection sort");
        selectionSortAscending.sort(arr);
        selectionSortAscending.printArray(arr, "After sorting in ascending order using Selection sort");

        final SelectionSort selectionSortDescending = new SelectionSort(new DescendingSort());
        selectionSortDescending.printArray(arr, "Before sorting in descending order using Selection sort");
        selectionSortDescending.sort(arr);
        selectionSortDescending.printArray(arr, "After sorting in descending order using Selection sort");
    }
}
