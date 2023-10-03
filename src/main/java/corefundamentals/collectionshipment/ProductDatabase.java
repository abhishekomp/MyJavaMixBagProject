package corefundamentals.collectionshipment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDatabase {
    public static List<Product> getProducts() {

        Product door = new Product("Wooden Door", 10);
        Product floorPanel = new Product("Floor Panel", 20);
        Product window = new Product("Glass Window", 30);
        Product windowFrame = new Product("Window Frame", 40);
        Product doorFrame = new Product("Door Frame", 50);

        List<Product> products = new ArrayList<>();
        Collections.addAll(products, door, floorPanel, window, windowFrame, doorFrame);

        return products;
    }
}
