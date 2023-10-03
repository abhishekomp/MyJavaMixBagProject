package corefundamentals.collection.unmodifiablelistdemo.dao;

import corefundamentals.collection.unmodifiablelistdemo.model.LineItem;
import corefundamentals.collection.unmodifiablelistdemo.model.Order;
import corefundamentals.collection.unmodifiablelistdemo.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sca820 on 22 nov., 2022
 */
public class OrderDAO {

    public static Order getOrderById(long orderId) {
        Product toothbrush = ProductDAO.getProduct("Electric Toothbrush");
        Product babyAlarm = ProductDAO.getProduct("Baby Alarm");
        Product ebook = ProductDAO.getProduct("War and Peace (e-book)");
        LineItem item1 = new LineItem(toothbrush, 1);
        LineItem item2 = new LineItem(babyAlarm, 2);
        LineItem item3 = new LineItem(ebook, 1);

        List<LineItem> itemsList = new ArrayList<>();
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);

        Order order = new Order(orderId, "IKEA-001", itemsList);
        return order;
    }
}
