package designpatterns.filterdesignpattern.filter_criteria_2nd_approach;

public class OrCriteria<T> implements iCriteria<T> {
    iCriteria<T> leftCriteria;
    iCriteria<T> rightCriteria;

    public OrCriteria(iCriteria<T> leftCriteria, iCriteria<T> rightCriteria) {
        this.leftCriteria = leftCriteria;
        this.rightCriteria = rightCriteria;
    }

    @Override
    public boolean matches(T candidate) {
        return leftCriteria.matches(candidate) || rightCriteria.matches(candidate);
    }
}
