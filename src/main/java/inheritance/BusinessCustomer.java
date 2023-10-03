package inheritance;

public class BusinessCustomer extends Customer{

    public enum BusinessSize {SMALL, MEDIUM, LARGE};

    private BusinessSize size;

    public BusinessCustomer(String name, BusinessSize size) {
        super(name);
        this.size = size;
        System.out.println("BusinessCustomer's constructor called");
    }

    @Override
    public int calculateDiscount() {
        switch (size) {
            case SMALL:
                return 5;
            case MEDIUM:
                return 10;
            case LARGE:
                return 20;
            default:
                throw new AssertionError("Unknown size type" + this);
        }
    }

    public int shippingForBusiness() {
        return 100;
    }
}
