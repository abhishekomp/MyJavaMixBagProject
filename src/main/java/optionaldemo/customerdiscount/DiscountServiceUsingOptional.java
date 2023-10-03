package optionaldemo.customerdiscount;

import java.util.Optional;

import static java.util.Optional.of;

public class DiscountServiceUsingOptional {
    public String getDiscountLine(Customer customer) {
        Optional<MemberCard> memberCard = customer.getMemberCardAsOptional();
        Optional<Integer> integer = memberCard.flatMap(card -> getDiscountPercentage(card));
        Optional<String> s = integer.map(d -> "Discount % " + d);
        //return customer.getMemberCard().flatMap(card -> getDiscountPercentage(card)).map(d -> "Discount % " + d).orElse("");
        return customer.getMemberCardAsOptional().flatMap(card -> getDiscountPercentage(card)).map(d -> "Discount % " + d).orElse("Customer doesn't has any card");
    }

    private Optional<Integer> getDiscountPercentage(MemberCard card) {
        if(card.getPoints() > 100) {
            return of(10);
        }
        if(card.getPoints() > 50) {
            return of(5);
        }
        //return empty();
        return of(0);
    }

    public static void main(String[] args) {
        DiscountServiceUsingOptional discountService = new DiscountServiceUsingOptional();
        //System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(110))));
        //System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(40))));
        //System.out.println(discountService.getDiscountLine(new Customer()));

        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(110))));
        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(60))));
        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(40))));
        System.out.println(discountService.getDiscountLine(new Customer()));
    }
}
