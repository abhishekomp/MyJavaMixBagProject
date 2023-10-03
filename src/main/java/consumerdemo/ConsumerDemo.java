package consumerdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Consumer<List<String>> consumer = aList -> aList.add("one");

        consumer.accept(list);
        list.stream().forEach(System.out::println);
    }
}
