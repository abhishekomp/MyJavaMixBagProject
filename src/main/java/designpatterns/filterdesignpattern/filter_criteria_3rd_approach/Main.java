package designpatterns.filterdesignpattern.filter_criteria_3rd_approach;


import designpatterns.filterdesignpattern.model.Laptop;
import designpatterns.filterdesignpattern.LaptopFactory;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

//https://medium.com/beingprofessional/think-functional-rethinking-criteria-pattern-with-lambdas-2bac1d77fe7d
public class Main {
    public static void main(String[] args) {
        //Get a list of laptops
        List<Laptop> laptops = LaptopFactory.manufactureInBulk();


        //1. Get all windows laptops
//        laptops.stream()
//                .filter(laptop -> new OSWindows().and(new I7Processor()).matches(laptop))
//                .forEach(System.out::println);

        //2. Get all Windows of Mac laptops
//        laptops.stream()
//                .filter(laptop -> new OSWindows().or(new OSMac()).matches(laptop))
//                .forEach(System.out::println);

        //3. Combining And and Or. Get all Windows and Mac laptops that I7 processor
//        laptops.stream()
//                .filter(laptop -> new OSWindows().or(new OSMac()).and(new I7Processor()).matches(laptop))
//                .forEach(System.out::println);

        //4. Get all Windows laptops and I7 Mac laptops
//        laptops.stream()
//                .filter(laptop -> new OSWindows().or(new OSMac().and(new I7Processor())).matches(laptop))
//                .forEach(System.out::println);

        //5. Using Predicate. Get all Windows and Mac laptops
//        Predicate<Laptop> isWindows = laptop -> laptop.getOperatingSystem().equalsIgnoreCase("WINDOWS");
//        Predicate<Laptop> isMac = laptop -> laptop.getOperatingSystem().equalsIgnoreCase("MAC");
//        Predicate<Laptop> isI7Processor = laptop -> laptop.getProcessor().equalsIgnoreCase("I7");

//        laptops.stream()
//                .filter(isWindows.or(isMac.and(isI7Processor)))
//                .forEach(System.out::println);

        //6. Currying. Do we need to write N number of predicates if there are N types of Operating Systems.
        //Answer is NO. We can take advantage of Function which will take the type of OS and return a Predicate for that OS
        Function<String, Predicate<Laptop>> osFilter = os -> laptop -> laptop.getOperatingSystem().equalsIgnoreCase(os);
        Function<String, Predicate<Laptop>> processorFilter = processor -> laptop -> laptop.getProcessor().equalsIgnoreCase(processor);
        //This is how we can use this
        //Get all laptops that have OS=Windows OR such which have (OS=Mac and processor = I7)
        System.out.println("All laptops which are Windows (any processor) and which are Mac with I7 processor");
        laptops.stream()
                .filter(osFilter.apply("Windows").or(osFilter.apply("Mac").and(processorFilter.apply("I7"))))
                .forEach(System.out::println);

        System.out.println("All laptops which are Windows or Mac and all must have I7 processor");
        laptops.stream()
                .filter((osFilter.apply("Windows").or(osFilter.apply("Mac"))).and(processorFilter.apply("I7")))
                .forEach(System.out::println);

    }
}
