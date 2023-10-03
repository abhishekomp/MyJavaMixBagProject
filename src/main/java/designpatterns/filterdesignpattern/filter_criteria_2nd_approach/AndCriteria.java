package designpatterns.filterdesignpattern.filter_criteria_2nd_approach;

public class AndCriteria<T> implements iCriteria<T> {
    iCriteria<T> leftCriteria;
    iCriteria<T> rightCriteria;

    public AndCriteria(iCriteria<T> leftCriteria, iCriteria<T> rightCriteria) {
        this.leftCriteria = leftCriteria;
        this.rightCriteria = rightCriteria;
    }

    @Override
    public boolean matches(T candidate) {
        return leftCriteria.matches(candidate) && rightCriteria.matches(candidate);
    }
}
