package designpatterns.filterdesignpattern.filter_criteria;

import designpatterns.filterdesignpattern.model.Laptop;

import java.util.List;

public class TopCriteria implements iCriteria{

    AndCriteria andCriteria;
    OrCriteria orCriteria;

    public TopCriteria(AndCriteria andCriteria, OrCriteria orCriteria) {
        this.andCriteria = andCriteria;
        this.orCriteria = orCriteria;
    }

    public TopCriteria(OrCriteria orCriteria, AndCriteria andCriteria) {
        this.andCriteria = andCriteria;
        this.orCriteria = orCriteria;
    }

    public TopCriteria(OrCriteria orCriteria) {
        this.orCriteria = orCriteria;
    }

    public TopCriteria(AndCriteria andCriteria) {
        this.andCriteria = andCriteria;
    }

    public TopCriteria() {
    }

    @Override
    public List<Laptop> meets(List<Laptop> laptops) {

        List<Laptop> filteredLaptops = laptops;

        if(orCriteria != null) {
            filteredLaptops = orCriteria.meets(filteredLaptops);
        }
        if(andCriteria != null) {
            filteredLaptops = andCriteria.meets(filteredLaptops);
        }
        return filteredLaptops;
    }
}
