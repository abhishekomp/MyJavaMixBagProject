package apnacollege.sorting.usingStrategyPattern.strategies;

import apnacollege.sorting.usingStrategyPattern.ArrayPrinter;
import apnacollege.sorting.usingStrategyPattern.Sortable;

public class InsertionSortAscending implements Sortable {
    @Override
    public void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] =current;
        }
    }

//    @Override
//    public void sortAndPrint(int[] arr) {
//        sort(arr);
//        ArrayPrinter.printArray(arr);
//    }
}
