package designpatterns.filterdesignpattern.filter_criteria_2nd_approach;

import designpatterns.filterdesignpattern.model.Laptop;

public class I7Processor implements iCriteria<Laptop> {

    @Override
    public boolean matches(Laptop candidate) {
        return "I7".equalsIgnoreCase(candidate.getProcessor());
    }
}
