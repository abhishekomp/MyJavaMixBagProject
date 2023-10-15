package corefundamentals.collection.iterator;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory {
    public static List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        Product tv = new Product("TV", 30);
        Product videoPlayer = new Product("VideoPlayer", 5);
        Product washingMachine = new Product("WashingMachine",40);
//        Product iPad = new Product("iPad", 1);
//        Product laptop = new Product("laptop", 2);
//        Product coffeeMaker = new Product("coffeeMaker", 5);
        products.add(tv);
        products.add(videoPlayer);
        products.add(washingMachine);
//        products.add(iPad);
//        products.add(laptop);
//        products.add(coffeeMaker);

        return products;
    }
}
