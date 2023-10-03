package corefundamentals.collection.unmodifiablelistdemo.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by sca820 on 22 nov., 2022
 */
public class Order {
    private long id;
    private String orderNumber;
    private List<LineItem> lineItems;

    public Order(long id, String orderNumber, List<LineItem> items) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.lineItems = items;
    }

    public List<LineItem> getLineItems() {
        return Collections.unmodifiableList(lineItems);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", lineItems=" + lineItems +
                '}';
    }
}
