package designpatterns.filterdesignpattern.filter_criteria;

import designpatterns.filterdesignpattern.model.Laptop;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class I3Processor implements iCriteria{
    
    @Override
    public List<Laptop> meets(List<Laptop> laptops) {
        return laptops.stream()
                .filter(laptop -> "I3".equalsIgnoreCase(laptop.getProcessor()))
                .collect(toList());
    }

    @Override
    public String toString() {
        return "I3Processor{}";
    }
}
