package onlineorderflow_v2;

/*
Requirement 1.1:
A customer creates an order by first adding various products, digital or physical, to a shopping cart, then checks out making a payment using their credit card.
*/

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {

        Product toothbrush = Catalogue.getProduct("Electric Toothbrush");
        Product babyAlarm = Catalogue.getProduct("Baby Alarm");

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addLineItem(new LineItem(toothbrush, 1));
        shoppingCart.addLineItem(new LineItem(babyAlarm, 2));

        System.out.println(shoppingCart);
        System.out.println(shoppingCart.getTotalCost());

        Customer johndoe = new Customer("ABC", 5789567856457L);
        Optional<Order> order = johndoe.checkout(shoppingCart);
        System.out.println(order);
    }
}
