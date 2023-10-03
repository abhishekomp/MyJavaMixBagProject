package designpatterns.decoratorpattern;

import designpatterns.decoratorpattern.beverage.Beverage;
import designpatterns.decoratorpattern.beverage.Espresso;
import designpatterns.decoratorpattern.condiment.Milk;
import designpatterns.decoratorpattern.condiment.Soy;

//https://betterprogramming.pub/decorator-pattern-4f92897e4b4
public class Main {
    public static void main(String[] args) {
        //1. Order simple Espresso
//        Beverage espresso = new Espresso();
//        System.out.println(espresso.getDescription() + " -> " + espresso.getCost());

        //2. Order Espresso with Soy and Milk
        Beverage beverage = new Espresso();
        beverage = new Soy(beverage);
        beverage = new Milk(beverage);
        System.out.println(beverage.getDescription() + " Rs. " + beverage.getCost());

    }
}
