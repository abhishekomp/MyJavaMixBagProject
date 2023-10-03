package optionaldemotwo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountServiceOptionalTest {

    @Test
    public void test_a_customer_with_two_cards_with_60_and_40_points() {
        Customer customer = new Customer();
        MemberCard card = new MemberCard(60);
        MemberCard card2 = new MemberCard(40);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        cards.add(card2);
        customer.setMemberCards(cards);

        DiscountServiceOptional service = new DiscountServiceOptional();
        String discountLines = service.getDiscountLines(customer);
        assertThat(discountLines).isNotNull();
    }

    @Test
    public void test_a_customer_with_two_cards_with_60_and_150_points() {
        Customer customer = new Customer();
        MemberCard card = new MemberCard(60);
        MemberCard card2 = new MemberCard(150);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        cards.add(card2);
        customer.setMemberCards(cards);

        DiscountServiceOptional service = new DiscountServiceOptional();
        String discountLines = service.getDiscountLines(customer);
        assertThat(discountLines).isNotNull();
    }

    @Test
    public void test_a_customer_with_no_cards() {
        DiscountServiceOptional service = new DiscountServiceOptional();
        String discountLines = service.getDiscountLines(new Customer());
        System.out.println(discountLines);
        //assertThat(discountLines).isEqualTo("Customer doesn't has any card");
    }

    @Test
    public void test_a_customer_with_one_card_with_20_points() {
        DiscountServiceOptional service = new DiscountServiceOptional();

        Customer customer = new Customer();
        MemberCard card = new MemberCard(20);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        customer.setMemberCards(cards);

        String discountLines = service.getDiscountLines(customer);
        System.out.println(discountLines);
    }

    @Test
    public void test_getCards_for_a_Customer() {
        Customer customer =  new Customer();
        List<MemberCard> memberCards = customer.getMemberCards();
        assertThat(memberCards.isEmpty()).isTrue();
    }

    @Test
    public void test_getCardDetails_with_Discount() {
        DiscountServiceOptional service = new DiscountServiceOptional();

        MemberCard card = new MemberCard("Visa", 60);
        String discountLines = service.getCardDetailsAndDiscount(card);
        System.out.println(discountLines);
    }

    @Test
    public void test_a_customer_with_a_singlecard_with_cardDetails_and_110_points() {
        DiscountServiceOptional service = new DiscountServiceOptional();

        Customer customer = new Customer();
        MemberCard card = new MemberCard("Visa", 110);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        customer.setMemberCards(cards);

        String discountLines = service.getDiscountLines(customer);
        System.out.println(discountLines);
    }

}
