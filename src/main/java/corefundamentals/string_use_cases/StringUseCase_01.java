package corefundamentals.string_use_cases;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sca820 on 09 juni, 2022
 */
public class StringUseCase_01 {
    //Given a long string with multiple occurrence of an xml tag. Objective is to get the value of the tag from all the occurrences
    //Example: This is a long string with 1st product as <HWProductPurchased>ApplePhone</HWProductPurchased>, 2nd product as <HWProductPurchased>Samsung Phone</HWProductPurchased> and 3rd product as <HWProductPurchased>Sony Phone Xperia 3</HWProductPurchased>. This is the end of the long string
    //For the above string, the result should be a list of all the values for the specified xml tag.

    //Referred: https://stackoverflow.com/questions/47749150/find-correct-regex-for-xml-tag-value-java
    //https://stackoverflow.com/questions/4662215/how-to-extract-a-substring-using-regex
    //https://www.regular-expressions.info/backref.html
    //https://www.rexegg.com/regex-quickstart.html
    //https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/

    List<String> extractListOfXMLValue(String longStr, String startSymbol, String stopSymbol) {

//        StringBuilder sb = new StringBuilder();
//        sb.append(startSymbol).append("([\\s\\S]*?)").append(stopSymbol);
//        Matcher m = Pattern.compile(sb.toString()).matcher(longStr);
//        System.out.println("sb = " + sb);
//        Matcher m = Pattern.compile("<HWProductPurchased>([\\s\\S]*?)<\\/HWProductPurchased>").matcher(longStr);

        List<String> extractedList = new ArrayList<>();
        Matcher m = Pattern.compile(startSymbol + "([\\s\\S]*?)" + stopSymbol).matcher(longStr);
        while (m.find())
        {
            extractedList.add(m.group(1));
        }
        return extractedList;
    }

    public static void main(String[] args) {
        StringUseCase_01 stringUseCase_01 = new StringUseCase_01();
//        String longStr = "This is a long string with 1st product as <HWProductPurchased>ApplePhone</HWProductPurchased>, 2nd product as <HWProductPurchased>Samsung Phone</HWProductPurchased> and 3rd product as <HWProductPurchased>Sony Phone Xperia 3</HWProductPurchased>. This is the end of the long string";
        //String longStr = "This is a long string with 1st product price as <HWProductCost>100Kr</HWProductCost>, 2nd product as <HWProductCost>9875Kr</HWProductCost> and 3rd product as <HWProductCost>8165Kr</HWProductCost>. This is the end of the long string";
        String longStr = "This is a long string with 1st product as <HWProductPurchased>ApplePhone 128Gb Svart</HWProductPurchased>, 2nd product as <HWProductPurchased>Samsung Phone</HWProductPurchased> and 3rd product as <HWProductPurchased>Sony Phone Xperia 3</HWProductPurchased>. This is the end of the long string. The price of the items is <ZHWProductCost>5056Kr</HWProductCost>Happy coding";
        //final List<String> strings = stringUseCase_01.extractListOfXMLValue(longStr, "<HWProductPurchased>", "</HWProductPurchased>");
        final List<String> strings = stringUseCase_01.extractListOfXMLValue(longStr, "<HWProductCost>", "</HWProductCost>");
        strings.forEach(System.out::println);

    }
}
