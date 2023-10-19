package corefundamentals.generics;

public class Box<T> {

    private final T t;

    public Box(T t) {
        this.t = t;
    }

    /**
     * This method can accept any array Integer[], String[], Character[]
     *
     * @param tArr
     */
    public void displayArr(T[] tArr) {
        for (T obj : tArr) {
            System.out.println(obj);
        }
    }

    /**
     * The <U> here is a way to specify that this method uses a type named U
     * The other way is to define the U at the class level and then every instance method will know about U and can accept U type object.
     * In this example, since U is not specified at the class level and hence we must specify it at the method level in order to use it.
     * @param u
     * @param <U>
     */
    public <U> void inspect(U u) {
        System.out.println("U's class: " + u.getClass().getName());
        System.out.println("T's class: " + t.getClass().getName());
    }
}
