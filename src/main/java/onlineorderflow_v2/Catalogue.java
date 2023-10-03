package onlineorderflow_v2;

import java.util.Map;

public class Catalogue {
    private static Map<String, Product> productMap = Map.of(
            "Electric Toothbrush", new Product("Electric Toothbrush", 3000),
            "Baby Alarm", new Product("Baby Alarm", 5000),
            "War and Peace (e-book)", new Product("War and Peace (e-book)", 1000)
    );

    public static Product getProduct(String productName) {
        return productMap.get(productName);
    }

}
