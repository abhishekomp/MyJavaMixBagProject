package corefundamentals.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

    public static void main(String[] args) {
        Product tv = new Product("TV", 30);
        Product videoPlayer = new Product("VideoPlayer", 5);
        Product washingMachine = new Product("WashingMachine",40);

        List<Product> productList = new ArrayList<>();
        productList.add(tv);
        productList.add(videoPlayer);
        productList.add(washingMachine);

        System.out.println("productList = " + productList);
//        productList.remove(0);
//        productList.remove(videoPlayer);
//        System.out.println("productList after removing = " + productList);
        productList.add(1, new Product("Chair", 12));
        //productList.set(1, new Product("Chair", 12));
        System.out.println("Updated productList = " + productList);

        //Iterator<Product> productIterator = productList.iterator();
        //System.out.println(productIterator.getClass().getSimpleName());

        //System.out.println(productList.contains(tv));       //prints true
        //System.out.println(productList.contains(new Product("TV", 30)));    //prints false
    }

}
