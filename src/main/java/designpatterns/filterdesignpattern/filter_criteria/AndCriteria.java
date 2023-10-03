package designpatterns.filterdesignpattern.filter_criteria;

import designpatterns.filterdesignpattern.model.Laptop;

import java.util.List;

public class AndCriteria implements iCriteria{

    private iCriteria[] criterias;

    public AndCriteria(iCriteria... criterias) {
        this.criterias = criterias;
//        System.out.println("Criteria count = " + criterias.length);
    }

    @Override
    public List<Laptop> meets(List<Laptop> laptops) {

        List<Laptop> filteredLaptops = laptops;

        for(iCriteria criteria : criterias) {
//            System.out.println("Processing criteria = " + criteria);
            filteredLaptops = criteria.meets(filteredLaptops);
        }
        return filteredLaptops;
    }
}
