package designpatterns.filterdesignpattern.filter_criteria;

import designpatterns.filterdesignpattern.model.Laptop;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class OSWindows implements iCriteria{
    
    @Override
    public List<Laptop> meets(List<Laptop> laptops) {
        return laptops.stream()
                .filter(laptop -> "WINDOWS".equalsIgnoreCase(laptop.getOperatingSystem()))
                .collect(toList());
    }

    @Override
    public String toString() {
        return "OSWindows{}";
    }
}
