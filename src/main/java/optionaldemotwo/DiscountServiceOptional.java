package optionaldemotwo;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class DiscountServiceOptional {

    public String getDiscountLines(Customer customer) {
        Stream<MemberCard> memberCardStream = Optional.ofNullable(customer.getMemberCards())
                .map(Collection::stream)
                .orElseGet(Stream::empty);

        List<String> defaultResponseList = List.of("Customer doesn't has any card");

        List<String> collect = Optional.ofNullable(customer.getMemberCards())
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(this::getDiscountPercentage)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(d -> "Discount % " + d)
                .collect(Collectors.toList());

        collect = (collect.size()>0) ? collect : defaultResponseList;

        //System.out.println("Collect = ");
        collect.stream().forEach(System.out::println);

        return "";
    }

    public String getDiscountLinesWithCardDetails(Customer customer) {
        Stream<MemberCard> cardStream = Optional.ofNullable(customer.getMemberCards())
                .map(Collection::stream)
                .orElseGet(Stream::empty);


        return "";
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

    public String getCardDetailsAndDiscount(MemberCard card) {
//        Optional<Integer> discountPercentage = getDiscountPercentage(card);
//        String unknown = discountPercentage.map(d -> String.valueOf(d)).orElse("0");
//        return card.getCardType() + " has " + s;

        return getDiscountPercentage(card).map(d -> card.getCardType() + " has discount% " + String.valueOf(d)).orElse("0");
    }

    public static void main(String[] args) {
        DiscountServiceOptional service = new DiscountServiceOptional();
//        MemberCard card = new MemberCard(60);
//        MemberCard card2 = new MemberCard(40);
//        List<MemberCard> cards = new ArrayList<>();
//        cards.add(card);
//        cards.add(card2);
//        System.out.println(service.getDiscountLines(new Customer(cards)));

        System.out.println("Customer with no cards");
        System.out.println(service.getDiscountLines(new Customer()));
    }

}
