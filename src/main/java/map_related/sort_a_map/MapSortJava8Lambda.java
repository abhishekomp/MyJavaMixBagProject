package map_related.sort_a_map;

import java.util.*;

public class MapSortJava8Lambda {
    public Map<String, Integer> sortMap(Map<String, Integer> inputMap) {

        //Collections.sort() takes a list to sort. We will create a list of entries from our input map.
        // Map has a Set of entries. We extract the entry Set and create a List of entries from it.
        // Creating a list of entries from the input map. Map has an entry set
        //Set<Map.Entry<String, Integer>> entrySet = inputMap.entrySet();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(inputMap.entrySet());
        //Collections.sort(entryList, new EntrySorter());

        //Here we specify the lambda as we need an implementation of a functional interface here. Comparator is a functional interface.
        //For sorting in descending order using the value
        //entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        entryList.sort(Comparator.comparingInt(Map.Entry::getValue));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
    public static void main(String[] args) {
        Map<String, Integer> nameToPrice = new HashMap<>();
        nameToPrice.put("Apple", 10);
        nameToPrice.put("Avocado", 20);
        nameToPrice.put("Banana", 15);
        nameToPrice.put("Mango", 25);
        nameToPrice.put("Starfruit", 40);
        System.out.println("nameToPrice = " + nameToPrice);

        MapSortJava8Lambda runner = new MapSortJava8Lambda();
        Map<String, Integer> sortedMap = runner.sortMap(nameToPrice);
        System.out.println("sortedMap = " + sortedMap);

    }
}
