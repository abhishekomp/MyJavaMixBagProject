package corefundamentals.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapsDemo {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("India", "New Delhi");
        map1.put("UK", "London");
        map1.put("Nepal", "Kathmandu");
        //System.out.println("map1 = " + map1);

//        String replace = map1.replace("India", "Indraprastha");     //replace works as update and returns the old value if key is found. If key is not found it returns null
//        System.out.println("replace = " + replace);
//        System.out.println("map1 = " + map1);

        //Iterating over map
//        map1.entrySet().stream().forEach(entry -> {
//            System.out.println(entry.getKey() + " has " + entry.getValue());
//        });

        Set<Map.Entry<String, String>> entries = map1.entrySet();
        for(Map.Entry<String, String> entry: entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            entry.setValue("WOOOOO");
        }
        System.out.println("map1 = " + map1);
    }
}
