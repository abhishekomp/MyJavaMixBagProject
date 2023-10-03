package inheritance;

public class PrivateCustomer extends Customer{

    public PrivateCustomer(String name) {
        super(name);
    }

    @Override
    public int calculateDiscount() {
        return 5;
    }
}
