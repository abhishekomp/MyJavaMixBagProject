package optionaldemo;

import optionaldemo.customerdiscount.Customer;
import optionaldemo.customerdiscount.DiscountServiceUsingOptional;
import optionaldemo.customerdiscount.MemberCard;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountServiceUsingOptionalTest {

    @Test
    public void testOptional_using_customer_with_card_with_110_points() {
        DiscountServiceUsingOptional discountService = new DiscountServiceUsingOptional();
        String discountLine = discountService.getDiscountLine(new Customer(new MemberCard(110)));
        System.out.println(discountLine);
        assertThat(discountLine).isEqualTo("Discount % 10");
    }

    @Test
    public void testOptional_using_customer_with_card_with_60_points() {
        DiscountServiceUsingOptional discountService = new DiscountServiceUsingOptional();
        String discountLine = discountService.getDiscountLine(new Customer(new MemberCard(60)));
        System.out.println(discountLine);
        assertThat(discountLine).isEqualTo("Discount % 5");
    }

    @Test
    public void testOptional_using_customer_with_card_with_40_points() {
        DiscountServiceUsingOptional discountService = new DiscountServiceUsingOptional();
        String discountLine = discountService.getDiscountLine(new Customer(new MemberCard(40)));
        System.out.println(discountLine);
        assertThat(discountLine).isEqualTo("Discount % 0");

    }

    @Test
    public void testOptional_using_customer_with_no_cards() {
        DiscountServiceUsingOptional discountService = new DiscountServiceUsingOptional();
        String discountLine = discountService.getDiscountLine(new Customer());
        System.out.println(discountLine);
        assertThat(discountLine).isEqualTo("Customer doesn't has any card");
    }
}
