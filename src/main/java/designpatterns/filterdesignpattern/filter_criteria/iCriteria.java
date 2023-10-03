package designpatterns.filterdesignpattern.filter_criteria;

import designpatterns.filterdesignpattern.model.Laptop;

import java.util.List;

public interface iCriteria {
    List<Laptop> meets(List<Laptop> laptops);
}
