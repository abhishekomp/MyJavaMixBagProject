package inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void calculateDiscount() {
        Customer cust = new Customer("CustA");
        System.out.println(cust.calculateDiscount());
    }

    @Test
    void calculateDiscountPrivateCustomer() {
        Customer cust = new PrivateCustomer("CustA");
        System.out.println(cust.calculateDiscount());
    }

    @Test
    void calculateDiscountBusinessCustomer() {
        Customer cust = new BusinessCustomer("CustA", BusinessCustomer.BusinessSize.LARGE);
//        System.out.println(cust.calculateDiscount());
//
//        BusinessCustomer bCust = new BusinessCustomer("bCust", BusinessCustomer.BusinessSize.MEDIUM);
//        System.out.println(bCust.shippingForBusiness());
    }
}