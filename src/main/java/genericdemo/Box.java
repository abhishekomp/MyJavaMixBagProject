package genericdemo;

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
}
