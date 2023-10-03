package java8practice.model.product;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sca820 on 06 dec., 2022
 */
public class Product {

    private final String skuCode;

    public Product(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public static Map<String, Long> skuCodeByCount() {
        Map<String, Long> skuCodeByCount = new HashMap<>();
        skuCodeByCount.put("AC001", 100L);
        skuCodeByCount.put("AC002", 200L);
        skuCodeByCount.put("AC003", 300L);
        skuCodeByCount.put("AC004", 400L);
        skuCodeByCount.put("AC005", 500L);
        return Collections.unmodifiableMap(skuCodeByCount);
    }
}
