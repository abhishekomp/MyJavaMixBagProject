package corefundamentals.string_use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sca820 on 18 okt., 2022
 */
class DecimalFormatDemoTest {

    DecimalFormatDemo dfdemo = new DecimalFormatDemo();

    @Test
    void formatNumberUsingComma() {
        System.out.println("Formatted String number:'" + dfdemo.formatNumberUsingComma(10) + "'");
        System.out.println("Formatted String number:'" + dfdemo.formatNumberUsingComma(100) + "'");
        System.out.println("Formatted String number:'" + dfdemo.formatNumberUsingComma(1000) + "'");
        System.out.println("Formatted String number:'" + dfdemo.formatNumberUsingComma(10000) + "'");
        System.out.println("Formatted String number:'" + dfdemo.formatNumberUsingComma(100000) + "'");
        System.out.println("Formatted String number:'" + dfdemo.formatNumberUsingComma(1000000) + "'");
    }

    @Test
    void formatUsingDecimalSymbol() {
        System.out.println("Formatted String number:'" + dfdemo.formatUsingDecimalSymbol(10) + "'");
        System.out.println("Formatted String number:'" + dfdemo.formatUsingDecimalSymbol(100) + "'");
        System.out.println("Formatted String number:'" + dfdemo.formatUsingDecimalSymbol(1000) + "'");
        System.out.println("Formatted String number:'" + dfdemo.formatUsingDecimalSymbol(10000) + "'");
        System.out.println("Formatted String number:'" + dfdemo.formatUsingDecimalSymbol(100000) + "'");
        System.out.println("Formatted String number:'" + dfdemo.formatUsingDecimalSymbol(1000000) + "'");
    }
}