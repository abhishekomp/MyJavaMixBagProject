package corefundamentals.collectionshipment;

import java.util.List;

public class ShipmentBreaker {
    static Product door = new Product("Wooden Door", 35);
    static Product floorPanel = new Product("Floor Panel", 25);
    static Product window = new Product("Glass Window", 10);

    public static void main(String[] args) {
        Shipment shipment = new Shipment();

        shipment.add(door);
        shipment.add(window);
        shipment.add(door);
        shipment.add(window);
        shipment.add(floorPanel);

        shipment.prepare();

        List<Product> lightVanProducts = shipment.getLightVanProducts();
        System.out.println("lightVanProducts = " + lightVanProducts);

        lightVanProducts.remove(window);

        System.out.println("Re-printing lightVanProducts = " + lightVanProducts);

        shipment.forEach(System.out::println);
    }
}
