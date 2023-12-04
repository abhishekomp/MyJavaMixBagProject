package corefundamentals.generics;

import java.util.Arrays;

public class ToArrayDemo<R> {

    private Object[] items;

    public ToArrayDemo(R[] items) {
        this.items = items;
    }

    public R[] toArray() {
        return (R[]) items;
    }

    public static void main(String[] args) {
        ToArrayDemo<Integer> integerTest = new ToArrayDemo<>(new Integer[] {
                1, 2, 3, 4
        });

        System.out.println(Arrays.toString(integerTest.toArray()));
    }

}
