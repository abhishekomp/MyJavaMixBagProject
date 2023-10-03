package designpatterns.filterdesignpattern.filter_criteria;

import designpatterns.filterdesignpattern.model.Laptop;

import java.util.ArrayList;
import java.util.List;

public class OrCriteria implements iCriteria{

    private iCriteria[] criterias;

    public OrCriteria(iCriteria... criterias) {
        this.criterias = criterias;
    }

    @Override
    public List<Laptop> meets(List<Laptop> laptops) {

        List<Laptop> filteredLaptops = new ArrayList<>();

        for(iCriteria criteria : criterias) {
            filteredLaptops.addAll(criteria.meets(laptops));
        }

        return filteredLaptops;
    }
}
