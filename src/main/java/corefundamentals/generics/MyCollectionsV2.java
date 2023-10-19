package corefundamentals.generics;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * In this class, the class does not accept any type as a parameter. Instead, it defines a method that accepts a List of any type using "List<?>"
 * But there is a problem. Now we can pass for example Arrays.asList(2.0, "Z", "Y". "X") to this method which will not throw any compile time error but will certainly throw a run time error.
 * To mitigate this problem, we can ask the client to always pass a list of single type elements when invoking this method.
 */
public class MyCollectionsV2 {

    public List<?> sortGeneric(List<?> unsortedList) {
        return unsortedList.stream().sorted().collect(toList());
    }

}
