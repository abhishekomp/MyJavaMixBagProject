package map_related.sort_a_map;

import java.util.HashMap;
import java.util.Map;

public class MapFactory {
    public static Map<String, Integer> createNameToPriceMap() {
        Map<String, Integer> nameToPrice = new HashMap<>();
        nameToPrice.put("Apple", 10);
        nameToPrice.put("Avocado", 20);
        nameToPrice.put("Banana", 15);
        nameToPrice.put("Mango", 25);
        nameToPrice.put("Starfruit", 40);
        return nameToPrice;
    }
}
