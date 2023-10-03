package optionaldemotwo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountServiceOptionalV2Test {
    @Test
    public void test_getDiscountLines_for_a_customer_with_one_card_with_110_points() {
        Customer customer =  new Customer();
        MemberCard card = new MemberCard(110);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        customer.setMemberCards(cards);

        DiscountServiceOptionalV2 service = new DiscountServiceOptionalV2();
        List<String> discountAsString = service.getDiscountAsString(customer);
        discountAsString.stream().forEach(System.out::println);
    }

    @Test
    public void test_a_customer_with_no_cards() {
        Customer customer =  new Customer();

        DiscountServiceOptionalV2 service = new DiscountServiceOptionalV2();
        List<String> discountAsString = service.getDiscountAsString(customer);
        discountAsString.stream().forEach(System.out::println);
    }

    @Test
    public void test_a_customer_with_two_cards_with_60_and_150_points() {
        Customer customer = new Customer();
        MemberCard card = new MemberCard(60);
        MemberCard card2 = new MemberCard(10);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        cards.add(card2);
        customer.setMemberCards(cards);

        DiscountServiceOptionalV2 service = new DiscountServiceOptionalV2();
        List<String> discountAsString = service.getDiscountAsString(customer);
        discountAsString.stream().forEach(System.out::println);
    }

    @Test
    public void test_getCardDetails_with_Discount() {
        DiscountServiceOptionalV2 service = new DiscountServiceOptionalV2();

        MemberCard card = new MemberCard("Visa", 100);
        String discountLines = service.getDiscountPercentWithCardDetails(card);
        System.out.println(discountLines);
    }

    @Test
    public void test_a_customer_with_a_singlecard_with_cardDetails_and_110_points() {
        DiscountServiceOptionalV2 service = new DiscountServiceOptionalV2();

        Customer customer = new Customer();
        MemberCard card = new MemberCard("Visa", 10);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        customer.setMemberCards(cards);

        List<String> discountAsString = service.getDiscountLines(customer);
        discountAsString.stream().forEach(System.out::println);
    }

    @Test
    public void test_a_customer_with_a_2_cards_with_cardDetails_and_110_points() {
        DiscountServiceOptionalV2 service = new DiscountServiceOptionalV2();

        Customer customer = new Customer();
        MemberCard card = new MemberCard("Visa", 10);
        MemberCard card2 = new MemberCard("MasterCard", 200);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        cards.add(card2);
        customer.setMemberCards(cards);

        List<String> discountAsString = service.getDiscountLines(customer);
        discountAsString.stream().forEach(System.out::println);
    }

    @Test
    public void test_a_customer_with_no_cards_usingNewfunction() {
        Customer customer =  new Customer();

        DiscountServiceOptionalV2 service = new DiscountServiceOptionalV2();
        List<String> discountAsString = service.getDiscountLines(customer);
        discountAsString.stream().forEach(System.out::println);
    }
}
