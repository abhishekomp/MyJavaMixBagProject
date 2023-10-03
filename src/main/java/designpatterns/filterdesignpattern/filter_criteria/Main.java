package designpatterns.filterdesignpattern.filter_criteria;

import designpatterns.filterdesignpattern.LaptopFactory;
import designpatterns.filterdesignpattern.model.Laptop;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Laptop> laptops = LaptopFactory.manufactureInBulk();

//        List<Laptop> filteredLaptops = new AndCriteria(new OSWindows(), new I3Processor()).meets(laptops);
//        List<Laptop> filteredLaptops = new AndCriteria(new OSWindows()).meets(laptops);
//        List<Laptop> filteredLaptops = new AndCriteria(new I3Processor()).meets(laptops);
//        List<Laptop> filteredLaptops = new AndCriteria(new I7Processor()).meets(laptops);

//        List<Laptop> filteredLaptops = new AndCriteria(new OSMac(), new I5Processor(), new Ram4GB(), new ScreenSize15Inch()).meets(laptops);

//        List<Laptop> filteredLaptops = new OrCriteria(new OSWindows(), new OSChromeBook()).meets(laptops);

//        final List<Laptop> filteredLaptops = new TopCriteria(new OrCriteria(new OSChromeBook(), new OSWindows())).meets(laptops);
//        final List<Laptop> filteredLaptops = new TopCriteria(new AndCriteria(new OSWindows(), new I3Processor())).meets(laptops);

//        final List<Laptop> filteredLaptops = new TopCriteria(
//                new OrCriteria(new OSChromeBook(), new OSWindows()),
//                new AndCriteria(new I5Processor()))
//                .meets(laptops);

//        final List<Laptop> filteredLaptops = new TopCriteria(
//                new OrCriteria(new OSMac(), new OSWindows()),
//                new AndCriteria(new I5Processor(), new Ram4GB()))
//                .meets(laptops);

//        final List<Laptop> filteredLaptops = new TopCriteria(
//                new OrCriteria(new OSMac(), new OSWindows(), new OSUbuntu()),
//                new AndCriteria(new I7Processor()))
//                .meets(laptops);

        final List<Laptop> filteredLaptops = new TopCriteria().meets(laptops);

        System.out.println("Found " + filteredLaptops.size() + " results");
        System.out.println("filteredLaptops = " + filteredLaptops);

        //1. Get all Windows laptops
        //2. Get all Windows i5 laptops
        //3. Get all laptops with i7 and 13inch screen size
        //4. Get all laptops whose ram is in range 2gb and 16gb
    }
}
