package orderingsystem;

import java.util.Iterator;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {

        Product toothbrush = Catalogue.getProduct("Electric Toothbrush");
        Product babyAlarm = Catalogue.getProduct("Baby Alarm");

        ShoppingCart cart = new ShoppingCart();
        cart.addLineItem(new LineItem(toothbrush, 1));
        cart.addLineItem(new LineItem(babyAlarm, 2));
        System.out.println(cart.getTotalCost());

        Customer johndoe = new Customer("John Doe", 5648648624578L);
        Optional<Order> order = johndoe.checkout(cart);
        System.out.println("order = " + order);
        order.ifPresent(Demo::fulfil);
        System.out.println("order = " + order);

    }

    public static void fulfil(Order o) {
        ShoppingCart cart = o.getCart();
        boolean shippingUnfinished;
        do {
            shippingUnfinished = false;
            for (Iterator<LineItem> it = cart.getLineItems().iterator(); it.hasNext(); ) {
                LineItem li = it.next();
                if (Math.random() > 0.7) {
                    shippingUnfinished = true;
                    System.out.println(li.getProduct() + " is out of stock");
                } else {
                    it.remove();
                }
            }
        } while (shippingUnfinished);
    }
}
