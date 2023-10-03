package onlineorderflow;

/*
Requirement 1.0:
A customer creates an order by first adding various products, digital or physical, to a shopping cart, then checks out making a payment using their credit card.
*/

public class Demo {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(Catalogue.getProduct("Electric Toothbrush"));
        shoppingCart.addProduct(Catalogue.getProduct("Baby Alarm"));

        System.out.println(shoppingCart);
        System.out.println(shoppingCart.getTotalCost());
    }
}
