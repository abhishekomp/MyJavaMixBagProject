package apnacollege.sorting.usingStrategyPattern.strategies;

import apnacollege.sorting.usingStrategyPattern.ArrayPrinter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortDescendingTest {

    int[] arr = {7, 8, 1, 3, 2};

    @Test
    void shouldSortTheArrayInDescendingOrder() {
        BubbleSortDescending bubbleSortDescending = new BubbleSortDescending();
        ArrayPrinter.printArray(arr, "Before Sort");
        bubbleSortDescending.sort(arr);
        ArrayPrinter.printArray(arr, "After Sort");
        assertThat(arr).containsExactly(8, 7, 3, 2, 1);
    }
}