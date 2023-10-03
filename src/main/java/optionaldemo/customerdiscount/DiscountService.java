package optionaldemo.customerdiscount;

public class DiscountService {
    public String getDiscountLine(Customer customer) {
        return "Discount % " + getDiscountPercentage(customer.getMemberCard());
        //return "";
    }

    private Integer getDiscountPercentage(MemberCard card) {
        if(card.getPoints() > 100) {
            return 10;
        }
        if(card.getPoints() > 50) {
            return 5;
        }
        return 0;
    }

    public static void main(String[] args) {
        DiscountService discountService = new DiscountService();
        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(110))));
        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(60))));
        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(40))));
        System.out.println(discountService.getDiscountLine(new Customer()));
    }
}
