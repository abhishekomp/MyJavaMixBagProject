package designpatterns.decoratorpattern.beverage;

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public int getCost() {
        return 30;
    }
}
