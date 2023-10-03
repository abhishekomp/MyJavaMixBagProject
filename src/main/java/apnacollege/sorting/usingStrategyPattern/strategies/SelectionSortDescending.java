package apnacollege.sorting.usingStrategyPattern.strategies;

import apnacollege.sorting.usingStrategyPattern.ArrayPrinter;
import apnacollege.sorting.usingStrategyPattern.Sortable;

public class SelectionSortDescending implements Sortable {
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

//    @Override
//    public void sortAndPrint(int[] arr) {
//        sort(arr);
//        ArrayPrinter.printArray(arr);
//    }
}
