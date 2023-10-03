package apnacollege.sorting.usingStrategyPattern.strategies;

import apnacollege.sorting.usingStrategyPattern.ArrayPrinter;
import apnacollege.sorting.usingStrategyPattern.Sortable;

public class SelectionSortAscending implements Sortable {
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

//    @Override
//    public void sortAndPrint(int[] arr) {
//        sort(arr);
//        ArrayPrinter.printArray(arr);
//    }
}
