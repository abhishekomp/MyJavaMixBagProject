package designpatterns.decoratorpattern.beverage;

public abstract class Beverage {
    String description = "unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract int getCost();
}
