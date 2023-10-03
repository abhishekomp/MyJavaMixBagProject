package corefundamentals.maps.java8enhancements;

import corefundamentals.maps.Product;
import corefundamentals.maps.ProductFixtures;

import java.util.HashMap;
import java.util.Map;

public class Java8Enhacements {
    public static void main(String[] args) {

        Product defaultProd = new Product("DUMMY PRODUCT", 100);

        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.window);
        idToProduct.put(3, ProductFixtures.floorPanel);

//        System.out.println(idToProduct.getOrDefault(4, defaultProd));
//        System.out.println(idToProduct.get(4));

        Product oldValue = idToProduct.replace(1, new Product("Big Door", 60));
        System.out.println("oldValue = " + oldValue);
        System.out.println("idToProduct = " + idToProduct);

        //replace-all
        //https://www.concretepage.com/java/java-8/java-map-replaceall
    }
}
