package genericdemo;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Box<T extends Number> {

    private T length;
    private T width;
    private T height;

    public Box(T length, T width, T height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Box() {

    }

    public T getLength() {
        return length;
    }

    public void setLength(T length) {
        this.length = length;
    }

    public double calculateVolume() {
        return  this.length.doubleValue() * this.width.doubleValue() * this.height.doubleValue();
    }

    public static <T extends Number> double calculateVolumeGenericMethod(T length, T width, T height) {
        return length.doubleValue() * width.doubleValue() * height.doubleValue();
    }

    /**
     * Converts a list of data type that extends Number to a List of Doubles
     * @param numbers a list of data type that extends Number
     * @return a list of Double
     */
    static List<Double> convertToDouble(List<? extends Number> numbers){
        return numbers.stream()
                .map(Number::doubleValue)
                .collect(toList());
    }
}
