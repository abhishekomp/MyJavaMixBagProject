package apnacollege.sorting.usingStrategyPattern.strategies;

import apnacollege.sorting.usingStrategyPattern.ArrayPrinter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BubbleSortAscendingTest {

    int[] arr = {7, 8, 1, 3, 2};

    @Test
    void shouldSortTheArrayInAscendingOrder() {
        BubbleSortAscending bubbleSortAscending = new BubbleSortAscending();
        ArrayPrinter.printArray(arr, "Before Sort");
        bubbleSortAscending.sort(arr);
        ArrayPrinter.printArray(arr, "After Sort");
        assertThat(arr).containsExactly(1, 2, 3, 7, 8);
    }
}