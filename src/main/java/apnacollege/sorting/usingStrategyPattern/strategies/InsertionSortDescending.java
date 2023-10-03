package apnacollege.sorting.usingStrategyPattern.strategies;

import apnacollege.sorting.usingStrategyPattern.ArrayPrinter;
import apnacollege.sorting.usingStrategyPattern.Sortable;

import java.lang.reflect.Field;

public class InsertionSortDescending implements Sortable {
    private static final String SORT_MESSAGE = "After sorting in Descending Order using Insertion Sort";

    public String getSortMessage() {
        return SORT_MESSAGE;
    }

    @Override
    public void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current > arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] =current;
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        InsertionSortDescending insertionSortDescending = new InsertionSortDescending();
//        Field f = InsertionSortDescending.class.getDeclaredField("SORT_MESSAGE");
//        f.setAccessible(true);
//        final String sort_message = (String) f.get(null);

        //Fetching private static field value using Reflection from the object instance
        final Field field_sortMsg = insertionSortDescending.getClass().getDeclaredField("SORT_MESSAGE");
        field_sortMsg.setAccessible(true);
        final String sort_message = (String) field_sortMsg.get(insertionSortDescending);
        System.out.println("sort_message = " + sort_message);
    }


//    @Override
//    public void sortAndPrint(int[] arr) {
//        sort(arr);
//        ArrayPrinter.printArray(arr);
//    }
}
