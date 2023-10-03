package apnacollege.sorting.usingStrategyPattern;

import apnacollege.sorting.usingStrategyPattern.strategies.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class ArraySorterTest {

    int[] arr = {7, 8, 1, 3, 2};

//    @BeforeEach
//    void printALineBeforeEachTest() {
//        System.out.println("-----------------");
//    }

    @AfterEach
    void printALineAfterEachTest() {
        System.out.println("-----------------");
    }

    @Test
    @DisplayName("Sorting an Integer Array in Ascending Order using Bubble Sort")
    void shouldSortTheArrayInAscendingOrderUsingBubbleSort() {
        ArraySorter arraySorter = new ArraySorter(new BubbleSortAscending());
        ArrayPrinter.printArray(arr, "Before Sort");
        arraySorter.sort(arr);
        ArrayPrinter.printArray(arr, "After Sort in Ascending Order using BubbleSort");
        assertThat(arr).containsExactly(1, 2, 3, 7, 8);
    }

    @Test
    @DisplayName("Sorting an Integer Array in Descending Order using Bubble Sort")
    void shouldSortTheArrayInDescendingOrderUsingBubbleSort() {
        ArraySorter arraySorter = new ArraySorter(new BubbleSortDescending());
        ArrayPrinter.printArray(arr, "Before Sort");
        arraySorter.sort(arr);
        ArrayPrinter.printArray(arr, "After Sorting in Descending Order using BubbleSort");
        assertThat(arr).containsExactly(8, 7, 3, 2, 1);
    }

    @Test
    @DisplayName("Sorting an Integer Array in Ascending Order using Selection Sort")
    void shouldSortTheArrayInAscendingOrderUsingSelectionSort() {
        ArraySorter arraySorter = new ArraySorter(new SelectionSortAscending());
        ArrayPrinter.printArray(arr, "Before Sort");
        arraySorter.sort(arr);
        ArrayPrinter.printArray(arr, "After Sort in Ascending Order using SelectionSort");
        assertThat(arr).containsExactly(1, 2, 3, 7, 8);
    }

    @Test
    @DisplayName("Sorting an Integer Array in Descending Order using Selection Sort")
    void shouldSortTheArrayInDescendingOrderUsingSelectionSort() {
        ArraySorter arraySorter = new ArraySorter(new SelectionSortDescending());
        ArrayPrinter.printArray(arr, "Before Sort");
        arraySorter.sort(arr);
        ArrayPrinter.printArray(arr, "After Sorting in Descending Order using SelectionSort");
        assertThat(arr).containsExactly(8, 7, 3, 2, 1);
    }

    @Test
    @DisplayName("Sorting an Integer Array in Ascending Order using Insertion Sort")
    void shouldSortTheArrayInAscendingOrderUsingInsertionSort() {
        ArraySorter arraySorter = new ArraySorter(new InsertionSortAscending());
        ArrayPrinter.printArray(arr, "Before Sort");
        arraySorter.sort(arr);
        ArrayPrinter.printArray(arr, "After Sort in Ascending Order using InsertionSort");
        assertThat(arr).containsExactly(1, 2, 3, 7, 8);
    }

    @Test
    @DisplayName("Sorting an Integer Array in Descending Order using Insertion Sort")
    void shouldSortTheArrayInDescendingOrderUsingInsertionSort() {
        ArraySorter arraySorter = new ArraySorter(new InsertionSortDescending());
        ArrayPrinter.printArray(arr, "Before Sort");
        arraySorter.sort(arr);
        ArrayPrinter.printArray(arr, "After Sorting in Descending Order using InsertionSort");
        assertThat(arr).containsExactly(8, 7, 3, 2, 1);
    }

    @Test
    @DisplayName("Sorting And Printing an Integer Array in Descending Order using Insertion Sort")
    void shouldSortTheArrayInDescendingOrderUsingInsertionSortAndPrintIt() throws NoSuchFieldException, IllegalAccessException {
        ArraySorter arraySorter = new ArraySorter(new InsertionSortDescending());
        arraySorter.sortAndPrint(arr);
        assertThat(arr).containsExactly(8, 7, 3, 2, 1);
    }

    @Test
    @DisplayName("Sorting And Printing an Integer Array in Ascending Order using Bubble Sort")
    void shouldSortAndPrintTheArrayInAscendingOrderUsingBubbleSort() throws NoSuchFieldException, IllegalAccessException {
        ArraySorter arraySorter = new ArraySorter(new BubbleSortAscending());
        //ArrayPrinter.printArray(arr, "Before Sort");
        arraySorter.sortAndPrint(arr);
        //ArrayPrinter.printArray(arr, "After Sort in Ascending Order using BubbleSort");
        assertThat(arr).containsExactly(1, 2, 3, 7, 8);
    }
}