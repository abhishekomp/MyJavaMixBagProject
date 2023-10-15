package corefundamentals.collection.iterator;

import java.util.Iterator;
import java.util.List;

public class IteratorDemo3 {
    public static void main(String[] args) {
        List<Product> products = ProductFactory.getProducts();
        Iterator<Product> it = products.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
