package corefundamentals.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyCollectionsV2Test {

    @Test
    void sort_integers_using_generic_method() {
        MyCollectionsV2 runner = new MyCollectionsV2();
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(9, 8, 7, 6));
        List<Integer> sortedList = (List<Integer>) runner.sortGeneric(unsortedList);
        sortedList.forEach(System.out::println);
    }

    @Test
    void sort_strings_using_generic_method() {
        MyCollectionsV2 runner = new MyCollectionsV2();
        List<String> unsortedList = new ArrayList<>(Arrays.asList("Z", "X", "Y", "W"));
        List<String> sortedList = (List<String>) runner.sortGeneric(unsortedList);
        sortedList.forEach(System.out::println);

    }
}