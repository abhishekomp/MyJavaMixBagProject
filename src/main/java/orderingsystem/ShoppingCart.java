package orderingsystem;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<LineItem> lineItems = new ArrayList<>();

    public ShoppingCart() {
        //default Constructor
    }

    public List<LineItem> getLineItems() {
        //return new ArrayList<>(lineItems);
        //return lineItems;
        return lineItems.stream()
                .map(LineItem::new)
                .collect(Collectors.toList());
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public int getTotalCost() {
        return lineItems.stream()
                .mapToInt(LineItem::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "lineItems=" + lineItems +
                '}';
    }
}
