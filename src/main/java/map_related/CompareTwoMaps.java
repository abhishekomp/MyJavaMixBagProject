package map_related;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CompareTwoMaps {

    public void getCommonEntriesFromMaps() {
        Map<String, String> mapA = new HashMap<String, String>();
        Map<String, String> mapB = new HashMap<String, String>();
        //Map<String, String> commonEntryMap = new HashMap<String, String>();

        mapA.put("1","value1");
        mapA.put("2","value2");
        mapA.put("3","value3");
        mapA.put("4","value4");
        mapA.put("5","value5");

        mapB.put("1","value1");
        mapB.put("2","value22");
        mapB.put("3","value2");
        //mapB.put("4","value4");
        //mapB.put("5","value5");

//        final Map<String, String> commonEntryMap = mapA.entrySet().stream()
//                .filter(entry -> mapB.containsKey(entry.getKey()))
//                .collect(Collectors.toMap(entry -> entry.getValue(), entry -> entry.getValue()));

//        final Map<String, String> commonEntryMap = mapA.entrySet().stream()
//                .filter(entry -> mapB.containsKey(entry.getKey()) && mapB.containsValue(entry.getValue()))
//                .collect(Collectors.toMap(entry -> entry.getValue(), entry -> entry.getValue()));
//
//        for(Map.Entry<String, String> entry: commonEntryMap.entrySet()) {
//            System.out.println(entry.getKey() + "->" + entry.getValue());

        final boolean containsAll = mapA.entrySet().containsAll(mapB.entrySet());
        System.out.println("containsAll = " + containsAll);
    }
}
