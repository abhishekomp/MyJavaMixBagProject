package onlineorderflow;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList = new ArrayList<>();

    public ShoppingCart() {
        //no-arg
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public int getTotalCost() {
        return productList.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "productList=" + productList +
                '}';
    }
}
