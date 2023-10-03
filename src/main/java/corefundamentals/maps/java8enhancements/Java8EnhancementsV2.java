package corefundamentals.maps.java8enhancements;

import java.util.HashMap;
import java.util.Map;

public class Java8EnhancementsV2 {
    public static void main(String[] args) {
        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(101, "Mahesh");
        studentMap.put(102, "Suresh");
        studentMap.put(103, "Krishna");

        System.out.println("studentMap = " + studentMap);
        
        //replaceAll
        studentMap.replaceAll((k, v) -> v + "-" + k);
        System.out.println("studentMap = " + studentMap);

        //compute if absent
        studentMap.computeIfAbsent(104, id -> "Abhishek-" + id);
        System.out.println("studentMap = " + studentMap);

        //forEach
        studentMap.forEach((k,v)-> System.out.println(v + " has id " + k));
    }
}
