package corefundamentals.string_use_cases;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sca820 on 09 juni, 2022
 */
class StringUseCase_01Test {

    @Test
    void extractHardwarePurchasedItemsAsList() {
        //String longStr = "This is a long string with 1st product as <HWProductPurchased>ApplePhone 128Gb Svart</HWProductPurchased>, 2nd product as <HWProductPurchased>Samsung Phone</HWProductPurchased> and 3rd product as <HWProductPurchased>Sony Phone Xperia 3</HWProductPurchased>. This is the end of the long string";
        String longStr = "This is a long string with 1st product as <HWProductPurchased>ApplePhone 128Gb Svart</HWProductPurchased>, 2nd product as <HWProductPurchased>Samsung Phone</HWProductPurchased> and 3rd product as <HWProductPurchased>Sony Phone Xperia 3</HWProductPurchased>. This is the end of the long string. The price of the items is <HWProductCost>5056Kr</HWProductCost>Happy coding";
        StringUseCase_01 stringUseCase_01 = new StringUseCase_01();
        final List<String> strings = stringUseCase_01.extractListOfXMLValue(longStr, "<HWProductPurchased>", "</HWProductPurchased>");
        strings.forEach(System.out::println);
//        assertThat(strings).contains("ApplePhone 128Gb Svart");
        assertThat(strings).containsExactlyInAnyOrder("ApplePhone 128Gb Svart", "Sony Phone Xperia 3", "Samsung Phone");
    }

    @Test
    void extractHardwarePurchasedCostAsString() {
        String longStr = "This is a long string with 1st product as <HWProductPurchased>ApplePhone 128Gb Svart</HWProductPurchased>, 2nd product as <HWProductPurchased>Samsung Phone</HWProductPurchased> and 3rd product as <HWProductPurchased>Sony Phone Xperia 3</HWProductPurchased>. This is the end of the long string. The price of the items is <HWProductCost>5056Kr</HWProductCost>Happy coding";
        StringUseCase_01 stringUseCase_01 = new StringUseCase_01();
        final List<String> strings = stringUseCase_01.extractListOfXMLValue(longStr, "<HWProductCost>", "</HWProductCost>");
        strings.forEach(System.out::println);
        assertThat(strings).contains("5056Kr");
    }

    @Test
    void extractHardwarePurchasedCostAsString_ButNotPresent() {
        String longStr = "This is a long string with 1st product as <HWProductPurchased>ApplePhone 128Gb Svart</HWProductPurchased>, 2nd product as <HWProductPurchased>Samsung Phone</HWProductPurchased> and 3rd product as <HWProductPurchased>Sony Phone Xperia 3</HWProductPurchased>. This is the end of the long string. The price of the items is <ZHWProductCost>5056Kr</HWProductCost>Happy coding";
        StringUseCase_01 stringUseCase_01 = new StringUseCase_01();
        final List<String> strings = stringUseCase_01.extractListOfXMLValue(longStr, "<HWProductCost>", "</HWProductCost>");
        strings.forEach(System.out::println);
        assertThat(strings).hasSize(0);
        //assertThat(strings).contains("5056Kr");
    }

    @Test
    void shouldReturnAListOfSizeZeroWhenNoMatchesFound() {
        String longStr = "This is a long string with 1st product as <ZHWProductPurchased>ApplePhone 128Gb Svart</HWProductPurchased>, 2nd product as <ZHWProductPurchased>Samsung Phone</HWProductPurchased> and 3rd product as <ZHWProductPurchased>Sony Phone Xperia 3</HWProductPurchased>. This is the end of the long string. The price of the items is <ZHWProductCost>5056Kr</HWProductCost>Happy coding";
        StringUseCase_01 stringUseCase_01 = new StringUseCase_01();
        final List<String> strings = stringUseCase_01.extractListOfXMLValue(longStr, "<HWProductPurchased>", "</HWProductPurchased>");
        strings.forEach(System.out::println);
        assertThat(strings).hasSize(0);
    }
}