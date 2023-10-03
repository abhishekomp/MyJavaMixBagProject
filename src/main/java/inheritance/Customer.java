package inheritance;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
        System.out.println("Customer's constructor called");
    }

    public int calculateDiscount() {
        return 0;
    }
}
