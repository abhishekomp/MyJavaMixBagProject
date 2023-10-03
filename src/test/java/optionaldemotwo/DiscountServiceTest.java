package optionaldemotwo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DiscountServiceTest {

    @Test
    public void test_a_customer_with_one_cards_with_60_points() {
        DiscountService service = new DiscountService();
        MemberCard card = new MemberCard(60);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        System.out.println(service.getDiscountLines(new Customer(cards)));
    }

    @Test
    public void test_a_customer_with_two_cards_with_150_and_60_points() {
        DiscountService service = new DiscountService();
        MemberCard card = new MemberCard(60);
        MemberCard card2 = new MemberCard(150);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        cards.add(card2);
        System.out.println(service.getDiscountLines(new Customer(cards)));
    }

    @Test
    public void test_a_customer_with_two_cards_with_150_and_40_points() {
        DiscountService service = new DiscountService();
        MemberCard card = new MemberCard(40);
        MemberCard card2 = new MemberCard(150);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        cards.add(card2);
        System.out.println(service.getDiscountLines(new Customer(cards)));
    }

    @Test
    public void test_a_customer_with_no_cards() {
        DiscountService service = new DiscountService();
        System.out.println(service.getDiscountLines(new Customer()));
    }

}
