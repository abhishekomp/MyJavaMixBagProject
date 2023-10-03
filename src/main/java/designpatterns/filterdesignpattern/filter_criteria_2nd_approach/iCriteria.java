package designpatterns.filterdesignpattern.filter_criteria_2nd_approach;

public interface iCriteria<T> {
    public boolean matches(T candidate);

    public default iCriteria<T> and(iCriteria<T> other) {
        return new AndCriteria<T>(this, other);
    }

    public default iCriteria<T> or(iCriteria<T> other) {
        return new OrCriteria<T>(this, other);
    }
}
