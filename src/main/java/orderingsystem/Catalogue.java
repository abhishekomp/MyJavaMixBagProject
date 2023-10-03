package orderingsystem;

import java.util.Map;

import static orderingsystem.ProductType.DIGITAL;
import static orderingsystem.ProductType.PHYSICAL;

public class Catalogue {
    private static Map<String, Product> productMap = Map.of(
            "Electric Toothbrush", new Product("Electric Toothbrush", 3000, PHYSICAL),
            "Baby Alarm", new Product("Baby Alarm", 5000, PHYSICAL),
            "War and Peace (e-book)", new Product("War and Peace (e-book)", 1000, DIGITAL)
    );

    public static Product getProduct(String productName) {
        return productMap.get(productName);
    }
}
