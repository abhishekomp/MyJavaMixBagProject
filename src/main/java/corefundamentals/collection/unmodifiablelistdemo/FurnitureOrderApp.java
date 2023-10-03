package corefundamentals.collection.unmodifiablelistdemo;

import corefundamentals.collection.unmodifiablelistdemo.dao.OrderDAO;
import corefundamentals.collection.unmodifiablelistdemo.dao.ProductDAO;
import corefundamentals.collection.unmodifiablelistdemo.model.LineItem;
import corefundamentals.collection.unmodifiablelistdemo.model.Order;

/**
 * Created by sca820 on 22 nov., 2022
 */
public class FurnitureOrderApp {

    private long orderId;

    public FurnitureOrderApp(long orderId) {
        this.orderId = orderId;
    }

    public static void main(String[] args) {
        FurnitureOrderApp app = new FurnitureOrderApp(1L);
        app.calculatePriceForOrder();
    }

    public void calculatePriceForOrder() {
        //fetch the order
        Order order = getOrderById(orderId);

        //client tries to add a new product
        order.getLineItems().add(new LineItem(ProductDAO.getProduct("Oxford Dictionary (e-book)"), 1));

        System.out.println(order);

        //calculate price
        int totalPrice = order.getLineItems().stream().map(item -> item.getPrice()).mapToInt(Integer::intValue).sum();
        System.out.println("totalPrice = " + totalPrice);
    }

    private Order getOrderById(long orderId) {
        return OrderDAO.getOrderById(orderId);
    }

}
