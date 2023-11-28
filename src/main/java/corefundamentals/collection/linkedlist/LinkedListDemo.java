package corefundamentals.collection.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        list.add("Peach");

        System.out.println("list = " + list);   //list = [Apple, Mango, Banana, Peach]

        final String s = list.get(2);
        System.out.println("s = " + s); //s = Banana
    }
}
