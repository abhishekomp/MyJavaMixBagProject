package map_related.sort_a_map;

import java.util.*;

public class MapSortTraditional {

    public Map<String, Integer> sortMap(Map<String, Integer> inputMap) {

        // Collections.sort() takes a list to sort. We will create a list of entries from our input map.
        // Map has a Set of entries. We extract the entry Set and create a List of entries from it.
        // Creating a list of entries from the input map. Map has an entry set
        // Set<Map.Entry<String, Integer>> entrySet = inputMap.entrySet();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(inputMap.entrySet());
        Collections.sort(entryList, new EntrySorterByValue());
        //entryList.sort(new EntrySorterByValue());
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    static class EntrySorterByKey implements Comparator<Map.Entry<String, Integer>> {

        // Sorting the Entries in ascending order of key
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getKey().compareTo(o2.getKey());
        }
    }

    static class EntrySorterByValue implements Comparator<Map.Entry<String, Integer>> {

        // Sorting the Entries in ascending order of key
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> nameToPrice = new HashMap<>();
        nameToPrice.put("Apple", 10);
        nameToPrice.put("Avocado", 20);
        nameToPrice.put("Banana", 15);
        nameToPrice.put("Mango", 25);
        nameToPrice.put("Starfruit", 40);
        System.out.println("nameToPrice = " + nameToPrice);

        MapSortTraditional runner = new MapSortTraditional();
        Map<String, Integer> sortedMap = runner.sortMap(nameToPrice);
        System.out.println("sortedMap = " + sortedMap);

    }
}
