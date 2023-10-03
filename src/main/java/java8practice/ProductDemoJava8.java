package java8practice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductDemoJava8 {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 10);
        Product doorFrame = new Product("Door Frame", 50);
        Product window = new Product("Glass Window", 30);
        Product floorPanel = new Product("Floor Panel", 20);
        Product windowFrame = new Product("Window Frame", 40);


        List<Product> products = List.of(door, floorPanel, window, windowFrame, doorFrame);

        //list all products in ascending order by weight
        //listbyWeightascending(products);
        //listbyNameascending(products);
        //listAllHeavierThan(products, window);
        //listAllProductsInDescendingOrderByWeight(products);
        //sumOfWeightOfAllProducts(products);
        //findTheMaxWeightProduct(products);
        //findAllProductsThatHasTheStringInName(products, "window");
        getProductsNameInUpperCaseWhoseWeightIsMoreThan(products, 10);
    }

    private static void getProductsNameInUpperCaseWhoseWeightIsMoreThan(List<Product> products, int weight) {
        List<String> stringList = products.stream()
                .filter(product -> product.getWeight() > 10)
                .map(Product::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("stringList = " + stringList);
    }

    private static void findAllProductsThatHasTheStringInName(List<Product> products, String str) {
        products.stream()
                .filter(product -> product.getName().toUpperCase().contains(str.toUpperCase()))
                .forEach(System.out::println);
    }

    private static void findTheMaxWeightProduct(List<Product> products) {
        final Optional<Product> max = products.stream()
                .max(Comparator.comparingInt(Product::getWeight));
        System.out.println("max = " + max.get());
    }

    private static void sumOfWeightOfAllProducts(List<Product> products) {
        Integer sum = products.stream()
                .map(product -> product.getWeight())
                //.reduce(0, (a, b) -> a + b);
                //.reduce(0, (total, weight) -> total + weight);
                //.reduce(0, (total, weight) -> Integer.sum(total, weight));
                .reduce(0, Integer::sum);
        System.out.println("Sum = " + sum);
    }

    private static void listAllProductsInDescendingOrderByWeight(List<Product> products) {
        products.stream()
                .sorted(Comparator.comparing(Product::getWeight).reversed())
                .forEach(System.out::println);
    }

    private static void listAllHeavierThan(List<Product> products, Product window) {
        products.stream()
                .filter(product -> product.getWeight() > window.getWeight())
                .forEach(System.out::println);
    }

    private static void listbyWeightascending(List<Product> products) {
        Comparator<Product> byWeight = Comparator.comparingInt(Product::getWeight);
        products.stream()
                .sorted(byWeight)
                .forEach(System.out::println);
    }

    private static void listbyNameascending(List<Product> products) {
        Comparator<Product> byName = Comparator.comparing(Product::getName);
        products.stream()
                .sorted(byName)
                .forEach(System.out::println);
    }
}
