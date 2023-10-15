package corefundamentals.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Scenario:
 * Suppose you have a list of fruits with you. You process each fruit against some logic and if it succeeds then you remove the fruit from the list
 * and move on to the next fruit. If the fruit fails the logic then you leave the fruit in the list and move on to the next fruit.
 * After you have visited all the fruits in the list you come back and start processing the fruits that were not processed in the previous pass.
 * You do this until all the fruits are processed.
 */
public class IteratorDemo3 {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Strawberry");
        boolean isFruitEaten;
        do {
            isFruitEaten = true;
            for(Iterator<String> it = fruits.iterator(); it.hasNext();){
                String fruit = it.next();
                if(Math.random() > 0.6){
                    System.out.println("Fruit " + fruit + " not eaten");
                    isFruitEaten = false;
                } else {
                    System.out.println("Fruit " + fruit + " eaten");
                    it.remove();
                }
            }
        }while(!isFruitEaten);
    }
}
