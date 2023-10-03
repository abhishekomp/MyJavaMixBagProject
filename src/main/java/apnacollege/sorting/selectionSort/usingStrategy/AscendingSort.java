package apnacollege.sorting.selectionSort.usingStrategy;

public class AscendingSort implements SortingBehaviour {

    @Override
    public void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int smallestAtIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[smallestAtIndex]) {
                    smallestAtIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallestAtIndex];
            arr[smallestAtIndex] = temp;
        }
    }
}
