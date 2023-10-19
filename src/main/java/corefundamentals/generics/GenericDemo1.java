package corefundamentals.generics;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GenericDemo1 {
    List<Double> performDouble(List<Number> numbers) {
        List<Double> collect = numbers.stream()
                .map(Number::doubleValue)
                .map(d -> d * 2.0)
                .collect(toList());
        return collect;
    }

    public static void main(String[] args) {
        GenericDemo1 runner = new GenericDemo1();
        List<Double> doubles = runner.performDouble(List.of(1, 2, 3));
        doubles.forEach(System.out::println);

        List<Integer> integers = List.of(1, 2, 3);
        //List<Double> doubles1 = runner.performDouble(integers);
    }

    /**
     * This method can accept any array Integer[], String[], Character[]
     * @param objArr
     */
    public void displayArray(Object[] objArr) {
        for(Object obj : objArr) {
            System.out.println(obj);
        }
    }

    /**
     * This method can accept any array Integer[], String[], Character[]
     * @param objArr
     */
    public <T> void displayArrayGeneric(T[] objArr) {
        for(T obj : objArr) {
            System.out.println(obj);
        }
    }

    /**
     * This method can accept any array Integer[], String[], Character[]
     * @param objArr
     */
    public static <T> void displayArrayStaticGeneric(T[] objArr) {
        for(T obj : objArr) {
            System.out.println(obj);
        }
    }


}
