package corefundamentals.collectionshipment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionOperationsDemo {

    static Product door = new Product("Wooden Door", 35);
    static Product floorPanel = new Product("Floor Panel", 25);
    static Product window = new Product("Glass Window", 10);

    public static void main(String[] args) {

        crateImmutableList();

        createMutableList();
    }

    private static void createMutableList() {
        List<Product> mutableProductsList = new ArrayList<>();
        Collections.addAll(mutableProductsList, door, floorPanel, window);
    }

    private static void crateImmutableList() {
        //This is immutable list
        List<Product> products = List.of(door, floorPanel, window);

        Product lightestProduct = Collections.min(products, Product.BY_WEIGHT);
        Product heaviestProduct = Collections.max(products, Product.BY_WEIGHT);

        System.out.println("heaviestProduct = " + heaviestProduct);
        System.out.println("lightestProduct = " + lightestProduct);
    }
}
