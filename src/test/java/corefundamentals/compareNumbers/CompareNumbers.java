package corefundamentals.compareNumbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


/**
 * Created by sca820 on 13 juni, 2022
 */
public class CompareNumbers {

//    @Test
//    void shouldCompareTwoFloatNumbersWithinPercentageRange() {
//        float f1 = 10.0f;
//        float f2 = 10.5f;
//        assertThat(f1).isCloseTo(f2, withinPercentage(5));
//    }

    @Test
    void shouldFailWhileCompareTwoFloatNumbersWithinPercentageRange() {
        float f1 = 10.0f;
        float f2 = 10.5f;
        //assertThat(f1).isCloseTo(f2, withinPercentage(5));
        float totalHwPriceSiebel = 100.0f;
        String hardwareProductCost = "102";
        assertThat(totalHwPriceSiebel).isCloseTo(Float.parseFloat(hardwareProductCost), within(5.0f));
        //assertThat(11.0f).isCloseTo(10.0f, withinPercentage(5.0));
        //assertThat(11).isCloseTo(10, withinPercentage(10));
    }

    @Test
    void shouldFailWhileCompareTwoDoubleNumbersWithinPercentageRange() {
        double f1 = 10.0;
        double f2 = 10.5;
        assertThat(f1).isCloseTo(f2, withinPercentage(5.0));
        //assertThat(11.0f).isCloseTo(10.0f, withinPercentage(5.0));
        //assertThat(11).isCloseTo(10, withinPercentage(10));
    }
}
