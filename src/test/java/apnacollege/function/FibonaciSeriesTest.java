package apnacollege.function;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sca820 on 23 juni, 2022
 */
class FibonaciSeriesTest {

    FibonaciSeries fibonaciSeries = new FibonaciSeries();

    @Test
    void generateFibonacciSequence() {
        final List<Long> longs = fibonaciSeries.generateFibonacciSequence(9);
        longs.forEach(System.out::println);
    }

    @Test
    void getNthNumber() {
        final long nthNumber = fibonaciSeries.getNthNumber(9);
        System.out.println("nthNumber = " + nthNumber);
        assertThat(nthNumber).isEqualTo(21L);
    }
}