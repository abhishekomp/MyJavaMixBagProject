package designpatterns.decoratorpattern.condiment;

import designpatterns.decoratorpattern.beverage.Beverage;

public class Milk extends CondimentDecorator{

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return beverage.getCost() + 30;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
