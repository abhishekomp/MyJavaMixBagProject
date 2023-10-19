package corefundamentals.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyCollectionsTest {

    @Test
    void sort_integers_using_non_generic_method() {
        MyCollections<Integer> runner = new MyCollections<>();
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(9, 8, 7, 6));
        List<Integer> sortedList = runner.sort(unsortedList);
        sortedList.forEach(System.out::println);
    }

    @Test
    void sort_integers_using_generic_method() {
        MyCollections<Integer> runner = new MyCollections<>();
        List<Integer> unsortedList = new ArrayList<>(Arrays.asList(9, 8, 7, 6));
        List<Integer> sortedList = runner.sortGeneric(unsortedList);
        sortedList.forEach(System.out::println);
    }

    @Test
    void sort_strings_using_generic_method() {
        MyCollections<String> runner = new MyCollections<>();
        List<String> unsortedList = new ArrayList<>(Arrays.asList("Z", "X", "Y", "W"));
        List<String> sortedList = runner.sortGeneric(unsortedList);
        sortedList.forEach(System.out::println);
    }
}