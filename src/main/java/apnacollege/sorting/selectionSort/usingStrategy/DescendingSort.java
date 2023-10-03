package apnacollege.sorting.selectionSort.usingStrategy;

public class DescendingSort implements SortingBehaviour {

    @Override
    public void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int biggestAtIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[biggestAtIndex]) {
                    biggestAtIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[biggestAtIndex];
            arr[biggestAtIndex] = temp;
        }
    }
}
