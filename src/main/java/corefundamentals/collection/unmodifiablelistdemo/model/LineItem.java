package corefundamentals.collection.unmodifiablelistdemo.model;

public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getPrice() {
        return product.getPrice()*quantity;
    }

    public LineItem(LineItem li) {
        this(li.product, li.quantity);
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public Product getProduct() {
        return product;
    }
}
