package corefundamentals.immutable;

public class ImmutableDemo1Runner {
    public static void main(String[] args) {
        ImmutableDemo1.ImmutableDemo2 immutableDemo2 = new ImmutableDemo1.ImmutableDemo2(10);
        System.out.println("immutableDemo2 = " + immutableDemo2);
        ImmutableDemo1.Destroyer destroyer = new ImmutableDemo1.Destroyer();
        destroyer.updateX(immutableDemo2, 20);
        System.out.println("immutableDemo2 = " + immutableDemo2);
    }
}
