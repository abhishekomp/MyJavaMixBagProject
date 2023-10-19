package corefundamentals.generics;

import java.util.List;

public class BoxWithWildCard<T extends Number> {
    private final T length;
    private final T width;

    public BoxWithWildCard(T length, T width) {
        this.length = length;
        this.width = width;
    }

    public T getLength() {
        return length;
    }

    public T getWidth() {
        return width;
    }

    public Double calculateArea() {
        return length.doubleValue() * width.doubleValue();
    }

    /**
     * Static generic methods need their own generic declaration (public static <U>) separate from the class's generic declaration (public class Box<T extends Number>).
     * @param length
     * @param width
     * @return
     * @param <U>
     */
    public static <U extends Number> Double calculateAreaAgain(U length, U width) {
        return length.doubleValue() * width.doubleValue();
    }

    public Double sumOfNumbers(List<T> numbers){
        double d = 0.0;
        for(T n : numbers){
            d += n.doubleValue();
        }
        return d;
    }

    public Double sumOfNumbersQuestionMark(List<? extends Number> numbers){
        double d = 0.0;
        for(Number n : numbers){
            d += n.doubleValue();
        }
        return d;
    }
}
