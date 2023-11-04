package map_related;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapScenarioTest {

    //https://stackoverflow.com/questions/56836097/how-to-compare-two-maps-and-retrieve-key-of-the-value-that-occurs-in-both-maps/57931314#57931314
    @Test
    public void find_key_with_same_values_in_two_maps(){
        Map<Integer, String> mapA = Map.of(1, "a", 2, "b", 3, "c");
        Map<Integer, String> mapB = Map.of(5, "a", 6, "d", 7, "c");

        //Set<Integer> actualSet = Collections.emptySet();
        Set<Integer> actualSet = mapB.keySet().stream()
                .filter(keyB -> mapA.keySet().stream()
                        .filter(keyA -> mapA.get(keyA).equals(mapB.get(keyB)))
                        .count() > 0)
                .collect(toSet());

        Set<Integer> expectedSet = Set.of(5, 7);
        assertEquals(expectedSet, actualSet);
    }

    //https://stackoverflow.com/questions/56836097/how-to-compare-two-maps-and-retrieve-key-of-the-value-that-occurs-in-both-maps/57931314#57931314
    @Test
    public void find_key_with_same_values_in_two_maps_approach2(){
        Map<Integer, String> mapA = Map.of(1, "a", 2, "b", 3, "c");
        Map<Integer, String> mapB = Map.of(5, "a", 6, "d", 7, "c");

        //Set<Integer> actualSet = Collections.emptySet();
        Set<Integer> actualSet = mapB.entrySet().stream()
                .filter(entryB -> mapA.values().contains(entryB.getValue()))
                .map(Map.Entry::getKey)
                .collect(toSet());

        Set<Integer> expectedSet = Set.of(5, 7);
        assertEquals(expectedSet, actualSet);
    }

    @Test
    public void test_put_method_replaces_value() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("John", "1");
        map.put("Ned", "2");
        map.put("Sansa", "3");
        map.put("John", "4");
        map.put("Jaime", "5");
        System.out.println("map = " + map);
    }

}
