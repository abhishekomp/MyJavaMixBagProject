package designpatterns.filterdesignpattern.filter_criteria;

import designpatterns.filterdesignpattern.model.Laptop;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ScreenSize15Inch implements iCriteria{
    
    @Override
    public List<Laptop> meets(List<Laptop> laptops) {
        return laptops.stream()
                .filter(laptop -> "15inch".equalsIgnoreCase(laptop.getScreenSize()))
                .collect(toList());
    }
}
