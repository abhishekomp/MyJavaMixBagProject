package corefundamentals.collection.iterator;

import java.util.Iterator;
import java.util.List;

public class IteratorDemo2 {
    public static void main(String[] args) {
        List<Product> products = ProductFactory.getProducts();
        boolean shippingUnfinished;
        do{
            shippingUnfinished = false;
            for(Iterator<Product> iterator = products.iterator(); iterator.hasNext();){
                Product product = iterator.next();
                if(Math.random() > 0.7) {
                    System.out.println("Shipping failed for: " + product);
                    shippingUnfinished = true;
                } else {
                    System.out.println("Shipping done for: " + product);
                    iterator.remove();
                }
            }
        } while(shippingUnfinished);
        System.out.println("Products at the end:");
        products.forEach(System.out::println);
    }

}
