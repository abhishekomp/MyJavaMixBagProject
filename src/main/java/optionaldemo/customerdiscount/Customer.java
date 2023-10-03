package optionaldemo.customerdiscount;

import java.util.Optional;

public class Customer {
    private String name;
    private MemberCard memberCard;

    public Customer(String name, MemberCard memberCard) {
        this.name = name;
        this.memberCard = memberCard;
    }

    public Customer(MemberCard memberCard) {
        this.memberCard = memberCard;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<MemberCard> getMemberCardAsOptional() {
        return Optional.ofNullable(memberCard);
    }

    public MemberCard getMemberCard() {
        return memberCard;
    }

    public void setMemberCard(MemberCard memberCard) {
        this.memberCard = memberCard;
    }

}
