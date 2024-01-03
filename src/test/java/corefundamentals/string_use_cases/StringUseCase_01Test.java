package corefundamentals.string_use_cases;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sca820 on 09 juni, 2022
 */
class StringUseCase_01Test {

    @Test
    void test_reverse_a_String_using_Stack_approach(){
        String input = "Hello";
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            stack.push(input.charAt(i));
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
        assertEquals("olleH", sb.toString());

        //Approach 2 using StringBuilder reverse method
        String result = new StringBuilder(input).reverse().toString();
        System.out.println(result);
        assertEquals("olleH", result.toString());
    }

    @Test
    void test_reverse_a_String_using_StringBuilder_approach(){
        String input = "Hello";

        //Approach 2 using StringBuilder reverse method
        String result = new StringBuilder(input).reverse().toString();
        System.out.println(result);
        assertEquals("olleH", result.toString());
    }
    @Test
    void test_reverse_a_String_using_logic() {
        String input = "Hello";
        char[] chars = input.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        char temp;
        while(end > begin) {
            temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            end--;
            begin++;
        }
        String result = new String(chars);
        System.out.println(result);
        assertEquals("olleH", result);
    }

    @Test
    void test_reverse_a_sentence(){
        String input = "Lily like to play";
        String[] split = input.split("\\s+");
        int begin = 0;
        int end = split.length - 1;
        String temp;
        while(end > begin){
            temp = split[begin];
            split[begin] = split[end];
            split[end] = temp;
            end--;
            begin++;
        }
        StringBuilder sb = new StringBuilder();
        for(String str : split){
            sb.append(str).append(' ');
        }
        System.out.println(sb);
        assertEquals("play to like Lily", sb.toString().trim());
    }

    @Test
    void test_reverse_a_sentence_using_forLoop(){
        String input = "Lily like to play";
        String[] split = input.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = split.length - 1; i >= 0; i--){
            sb.append(split[i]).append(' ');
        }
        assertEquals("play to like Lily", sb.toString().trim());
    }

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

    @Test
    void test_string_join_puts_a_space_at_the_end(){
        List<String> strings = List.of("All", "is", "fine", "today");
        String result = String.join(" ", strings);
        System.out.println("Result: " + result + " has length: " + result.length());
        String resultWithNewLine = String.join("\n", strings);
        System.out.println("Result: " + resultWithNewLine + " has length: " + resultWithNewLine.length());

        String anotherString = "The quick brown fox jumps over the lazy dog";
        System.out.println(anotherString.length()/3);

    }


}