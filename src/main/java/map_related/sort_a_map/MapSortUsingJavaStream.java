package map_related.sort_a_map;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Comparator.comparing;
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

    public Map<String, Integer> sortMapByKeyReversedVersion2(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMapByKeyReversed = inputMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,(a, b)-> a, LinkedHashMap::new));
        return sortedMapByKeyReversed;
    }

    /**
     * Sorts a map with key as String and value as Integer by Value
     * @param inputMap
     * @return Map with value of type Integer sorted in ascending order
     */
    public Map<String, Integer> sortMapByValue(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMap = inputMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,(a, b)-> a, LinkedHashMap::new));

//        Map<String, Integer> sortedMap2 = inputMap.entrySet().stream()
//                .sorted(Comparator.comparing(Map.Entry::getValue))
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

    public Map<String, Integer> sortMapByValueComparatorComparing(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMapReversed = inputMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        return sortedMapReversed;
    }

    public Map<String, Integer> sortMapByValueReversedComparatorComparing(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMapReversed = inputMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        return sortedMapReversed;
    }

    public Map<String, Integer> sortMapByValueReversedVersion2(Map<String, Integer> inputMap) {
        Map<String, Integer> sortedMapReversed = inputMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,(a, b)-> a, LinkedHashMap::new));
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
