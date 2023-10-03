package optionaldemotwo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiscountServiceOptionalV2 {
    public List<String> getDiscountAsString(Customer customer) {

        List<String> defaultResponseList = List.of("Customer doesn't has any card");

        Stream<MemberCard> memberCardStream = Optional.ofNullable(customer.getMemberCards())
                .map(Collection::stream)
                .orElseGet(Stream::empty);

        List<String> collect = Optional.ofNullable(customer.getMemberCards())
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(this::getDiscountPercentage)
                .map(d -> "Discount % " + d)
                .collect(Collectors.toList());

        collect = (collect.size()>0) ? collect : defaultResponseList;

        return collect;
    }

    public List<String> getDiscountLines(Customer customer) {

        List<String> defaultResponseList = List.of("Customer doesn't has any card");

        Stream<MemberCard> memberCardStream = Optional.ofNullable(customer.getMemberCards())
                .map(Collection::stream)
                .orElseGet(Stream::empty);

        List<String> collect = Optional.ofNullable(customer.getMemberCards())
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(this::getDiscountPercentWithCardDetails)
                .collect(Collectors.toList());

        collect = (collect.size()>0) ? collect : defaultResponseList;

        return collect;
    }

    public String getDiscountPercentWithCardDetails(MemberCard card) {
        return card.getCardType() + " has discount % " + String.valueOf(getDiscountPercentage(card));
    }

    public Integer getDiscountPercentage(MemberCard card) {
        if(card.getPoints() >= 100) {
            return 10;
        }
        if(card.getPoints() >= 50) {
            return 5;
        }
        return 0;
    }
}
