package map_related.sort_a_map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class MapSortUsingJavaStreamTest {

    private Map<String, Integer> nameToPriceMap;
    private MapSortUsingJavaStream mapSortUsingJavaStream;
    private static final String INCORRECT_KEY = "incorrectKey";
    private static final String KEY = "key";
    private static final int VALUE = 0;

    @BeforeEach
    void createAndInitializeMap() {
        nameToPriceMap = MapFactory.createNameToPriceMap();
        mapSortUsingJavaStream = new MapSortUsingJavaStream();
        //nameToPriceMap.put(KEY, VALUE);
    }

    @Test
    void sortMap_should_return_a_map_sorted_by_key_in_naturalOrder() {

        Map<String, Integer> sortedMap = mapSortUsingJavaStream.sortMapByKey(nameToPriceMap);
        System.out.println("sortedMapByKey = " + sortedMap);

        List<String> actualKeysList = new ArrayList<>(sortedMap.keySet());
        System.out.println("actualKeysList = " + actualKeysList);

        List<String> expectedKeysList = List.of("Apple", "Avocado", "Banana", "Mango", "Starfruit");
        assertIterableEquals(actualKeysList, expectedKeysList);
    }


    @Test
    void sortMap_should_return_a_map_sorted_by_keys_in_reversedOrder() {

        Map<String, Integer> sortedMap = mapSortUsingJavaStream.sortMapByKeyReversed(nameToPriceMap);
        System.out.println("sortedMapByValue = " + sortedMap);

        List<String> actualKeysList = new ArrayList<>(sortedMap.keySet());
        System.out.println("actualKeysList = " + actualKeysList);

        List<String> expectedKeysList = List.of("Starfruit", "Mango", "Banana", "Avocado", "Apple");
        assertIterableEquals(actualKeysList, expectedKeysList);
    }

    @Test
    void sortMap_should_return_a_map_sorted_by_value_in_naturalOrder() {

        Map<String, Integer> sortedMap = mapSortUsingJavaStream.sortMapByValue(nameToPriceMap);
        System.out.println("sortedMapByValue = " + sortedMap);

        List<Integer> actualValuesList = new ArrayList<>(sortedMap.values());
        System.out.println("actualValuesList = " + actualValuesList);

        List<Integer> expectedValuesList = List.of(10, 15, 20, 25, 40);
        assertIterableEquals(actualValuesList, expectedValuesList);
    }

    @Test
    void sortMap_should_return_a_map_sorted_by_value_in_reversedOrder() {

        Map<String, Integer> sortedMapReversed = mapSortUsingJavaStream.sortMapByValueReversed(nameToPriceMap);
        System.out.println("sortedMapByValueReversed = " + sortedMapReversed);

        ArrayList<Integer> actualValuesList = new ArrayList<>(sortedMapReversed.values());
        System.out.println("actualValuesList = " + actualValuesList);

        List<Integer> expectedValuesList = List.of(40, 25, 20, 15, 10);
        assertIterableEquals(actualValuesList, expectedValuesList);
    }
}