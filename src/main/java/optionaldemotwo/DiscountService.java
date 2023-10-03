package optionaldemotwo;


import java.util.ArrayList;
import java.util.List;

public class DiscountService {

    public String getDiscountLines(Customer customer) {
        List<MemberCard> memberCards = customer.getMemberCards();
        StringBuilder sb = new StringBuilder();
        for(MemberCard card : memberCards) {
            sb.append("Discount % " + getDiscountPercentage(card)).append("\n");
        }
        return sb.toString();
    }

    private Integer getDiscountPercentage(MemberCard card) {
        if(card.getPoints() > 100) {
            return 10;
        }
        if(card.getPoints() > 50) {
            return 5;
        }
        return null;
    }

    public static void main(String[] args) {
        DiscountService service = new DiscountService();
        MemberCard card = new MemberCard(60);
        MemberCard card2 = new MemberCard(40);
        List<MemberCard> cards = new ArrayList<>();
        cards.add(card);
        cards.add(card2);
        System.out.println(service.getDiscountLines(new Customer(cards)));
    }

}
