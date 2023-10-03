package optionaldemotwo;

public class MemberCard {
    private String cardType;
    private int points;

    public MemberCard(int points) {
        this.points = points;
    }

    public MemberCard(String cardType, int points) {
        this.cardType = cardType;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
