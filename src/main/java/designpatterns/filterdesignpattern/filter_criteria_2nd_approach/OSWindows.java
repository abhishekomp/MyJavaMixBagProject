package designpatterns.filterdesignpattern.filter_criteria_2nd_approach;

import designpatterns.filterdesignpattern.model.Laptop;

public class OSWindows implements iCriteria<Laptop> {

    @Override
    public boolean matches(Laptop candidate) {
        return "WINDOWS".equalsIgnoreCase(candidate.getOperatingSystem());
    }
}
