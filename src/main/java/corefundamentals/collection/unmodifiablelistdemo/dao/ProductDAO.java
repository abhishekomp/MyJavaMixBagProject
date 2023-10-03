package corefundamentals.collection.unmodifiablelistdemo.dao;

import corefundamentals.collection.unmodifiablelistdemo.model.Product;
import corefundamentals.collection.unmodifiablelistdemo.model.ProductType;

import java.util.Map;

/**
 * Created by sca820 on 22 nov., 2022
 */
public class ProductDAO {
    private static Map<String, Product> productMap = Map.of(
            "Electric Toothbrush", new Product("Electric Toothbrush", 3000, ProductType.PHYSICAL),
            "Baby Alarm", new Product("Baby Alarm", 5000, ProductType.PHYSICAL),
            "War and Peace (e-book)", new Product("War and Peace (e-book)", 1000, ProductType.DIGITAL),
            "Oxford Dictionary (e-book)", new Product("Oxford Dictionary (e-book)", 2000, ProductType.DIGITAL)
    );

    public static Product getProduct(String productName) {
        return productMap.get(productName);
    }
}
