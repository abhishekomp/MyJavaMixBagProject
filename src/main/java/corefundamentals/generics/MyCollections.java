package corefundamentals.generics;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * The class accepts the type T as parameter and then any instance variable, instance method can make use of this type.
 * We are making use of this type in our method sortGeneric.
 * It is not necessary to have a instance variable of type T. In this case we have a method that accepts a List of type T
 * @param <T>
 */
public class MyCollections<T> {

    public List<Integer> sort(List<Integer> unsortedList){
        return unsortedList.stream().sorted().collect(toList());
    }

    public List<T> sortGeneric(List<T> unsortedList) {
        return unsortedList.stream().sorted().collect(toList());
    }

}
