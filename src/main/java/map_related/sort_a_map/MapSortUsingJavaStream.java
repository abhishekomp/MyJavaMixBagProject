package map_related.sort_a_map;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class MapSortUsingJavaStream {


    public Map<String, Integer> sortMapByKey(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMapByKey = inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,(a, b)-> a, LinkedHashMap::new));
        return sortedMapByKey;
    }

    public Map<String, Integer> sortMapByKeyReversed(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMapByKeyReversed = inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,(a, b)-> a, LinkedHashMap::new));
        return sortedMapByKeyReversed;
    }

    /**
     * Sorts a map with key as String and value as Integer by Value
     * @param inputMap
     * @return
     */
    public Map<String, Integer> sortMapByValue(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMap = inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,(a, b)-> a, LinkedHashMap::new));

//        Map<String, Integer> sortedMap2 = inputMap.entrySet().stream()
//                .sorted(Comparator.comparing(Map.Entry::getKey))
//                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,(a, b)-> a, LinkedHashMap::new));
        return sortedMap;
    }

    public Map<String, Integer> sortMapByValueReversed(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMapReversed = inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,(a, b)-> a, LinkedHashMap::new));

//        Map<String, Integer> sortedMap2 = inputMap.entrySet().stream()
//                .sorted(Comparator.comparing(Map.Entry::getKey))
//                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,(a, b)-> a, LinkedHashMap::new));
        return sortedMapReversed;
    }

    public static void main(String[] args) {
        Map<String, Integer> nameToPriceMap = MapFactory.createNameToPriceMap();
        System.out.println("nameToPriceMap = " + nameToPriceMap);
        MapSortUsingJavaStream runner = new MapSortUsingJavaStream();
        Map<String, Integer> sortedMap = runner.sortMapByValue(nameToPriceMap);
        System.out.println("sortedMap = " + sortedMap);
    }

}
