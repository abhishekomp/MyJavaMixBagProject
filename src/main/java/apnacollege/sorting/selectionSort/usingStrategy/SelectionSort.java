package apnacollege.sorting.selectionSort.usingStrategy;

public class SelectionSort {

    private SortingBehaviour sortingBehaviour;

    public SelectionSort(SortingBehaviour sortingBehaviour) {
        this.sortingBehaviour = sortingBehaviour;
    }

    public void sort(int[] arr) {
        this.sortingBehaviour.sort(arr);
    }

    public void printArray(int[] arr, String msg) {
        System.out.println(msg);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
