package apnacollege.sorting.usingStrategyPattern.strategies;

import apnacollege.sorting.usingStrategyPattern.ArrayPrinter;
import apnacollege.sorting.usingStrategyPattern.Sortable;

public class BubbleSortDescending implements Sortable {
    @Override
    public void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

//    @Override
//    public void sortAndPrint(int[] arr) {
//        sort(arr);
//        ArrayPrinter.printArray(arr);
//    }
}
