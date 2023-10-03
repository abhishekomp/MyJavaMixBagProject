package apnacollege.sorting.usingStrategyPattern;

import java.lang.reflect.Field;

public class ArraySorter {
    private Sortable sortable;

    public ArraySorter(Sortable sortable) {
        this.sortable = sortable;
    }

    public void sort(int[] arr) {
        this.sortable.sort(arr);
    }

    public void sortAndPrint(int[] arr) throws NoSuchFieldException, IllegalAccessException {
        ArrayPrinter.printArray(arr, "Before Sorting");
        this.sortable.sort(arr);
        //get the static message from the implementation class
        final String messageFromImplClass = getMessageFromImplClass();

        ArrayPrinter.printArray(arr, messageFromImplClass);
    }

    private String getMessageFromImplClass() throws NoSuchFieldException, IllegalAccessException {
        final Field sortableImpl = this.sortable.getClass().getDeclaredField("SORT_MESSAGE");
        sortableImpl.setAccessible(true);
        final String sort_message = (String) sortableImpl.get(sortableImpl);
//        System.out.println("sort_message = " + sort_message);
        return sort_message;
    }
}
