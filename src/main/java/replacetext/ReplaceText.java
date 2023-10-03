package replacetext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReplaceText {

    public static String input = "89460110200820024852";

    public static void main(String[] args) {


        ReplaceText.replaceStartingMethod(List.of("89460110200820024910"));

//        Map<String,String> variableMap = fillMap();
//        Path path = Paths.get("src/test/resources/se/telia/teres/ICC-numbers.txt");
//        Stream<String> lines;
//        try {
//            lines = Files.lines(path,Charset.forName("UTF-8"));
//            List<String> replacedLines = lines.map(line -> replaceTag(line,variableMap))
//                    .collect(Collectors.toList());
//            System.out.println("Size of replacedLines" + replacedLines.size());
//            Files.write(path, replacedLines, Charset.forName("UTF-8"));
//            lines.close();
//            System.out.println("Find and replace done");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public static void replaceStartingMethod(List<String> strList) {
        Map<String, String> stringStringMap = fillMap(strList);

        Path path = Paths.get("src/test/resources/se/telia/teres/ICC-numbers.txt");
        Stream<String> lines;
        try {
            lines = Files.lines(path,Charset.forName("UTF-8"));
            List<String> replacedLines = lines.map(line -> replaceTag(line,stringStringMap))
                    .collect(Collectors.toList());
            System.out.println("Size of replacedLines" + replacedLines.size());
            Files.write(path, replacedLines, Charset.forName("UTF-8"));
            lines.close();
            System.out.println("Find and replace done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Map<String,String> fillMap() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("() 89460110200820024852", "(U) 89460110200820024852");
        map.put("() 89460110200820024910", "(U) 89460110200820024910");

        StringBuilder sbKey = new StringBuilder(input);
        sbKey.insert(0,"() ");
        System.out.println("Input = " + input);
        System.out.println("Modified Input as Key = " + sbKey.toString());

        StringBuilder sbVal = new StringBuilder(input);
        sbVal.insert(0,"(U) ");
        System.out.println("Input = " + input);
        System.out.println("Modified Input as Value = " + sbVal.toString());


        //map.put("<<age>>", "25");
        return map;
    }

    public static Map<String,String> fillMap(List<String> strList) {
        Map<String,String> map = new HashMap<String,String>();
//        map.put("() 89460110200820024852", "(U) 89460110200820024852");
//        map.put("() 89460110200820024910", "(U) 89460110200820024910");

        for(String str : strList) {
            StringBuilder sbKey = new StringBuilder(str);
            sbKey.insert(0,"() ");
            StringBuilder sbVal = new StringBuilder(str);
            sbVal.insert(0,"(U) ");
            map.put(sbKey.toString(), sbVal.toString());
        }

//        StringBuilder sbKey = new StringBuilder(input);
//        sbKey.insert(0,"() ");
//        System.out.println("Input = " + input);
//        System.out.println("Modified Input as Key = " + sbKey.toString());
//
//        StringBuilder sbVal = new StringBuilder(input);
//        sbVal.insert(0,"(U) ");
//        System.out.println("Input = " + input);
//        System.out.println("Modified Input as Value = " + sbVal.toString());


        //map.put("<<age>>", "25");
        return map;
    }
    private static String replaceTag(String str, Map<String,String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.contains(entry.getKey())) {
                str = str.replace(entry.getKey(), entry.getValue());
            }
        }
        return str;
    }
}
