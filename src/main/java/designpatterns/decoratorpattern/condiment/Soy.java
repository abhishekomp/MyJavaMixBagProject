package designpatterns.decoratorpattern.condiment;

import designpatterns.decoratorpattern.beverage.Beverage;

public class Soy extends CondimentDecorator{

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public int getCost() {
        return beverage.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
