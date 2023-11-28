package corefundamentals.immutable;

public class ImmutableDemo1 {
    static class ImmutableDemo2 {
        /*
        Without specifying the field x as final, the compiler doesn't complain even if we are changing the state of ImmutableDemo2 object inside the Destroyer class
        If we happen to specify the field x in ImmutableDemo2 as final, then the code will not compile because now we cannot modify the field x of ImmutableDemo2 from the "updateX" method defined in another class
         */
        private int x;

        public ImmutableDemo2(int x){
            this.x = x;
        }

        @Override
        public String toString(){
            return "" + x;
        }
    }
    static class Destroyer {
        public void updateX(ImmutableDemo2 immutableDemo2, int newValue){
            immutableDemo2.x = newValue;
        }
    }

    public static void main(String[] args) {
        ImmutableDemo2 immutableDemo2 = new ImmutableDemo2(10);
        System.out.println("immutableDemo2 = " + immutableDemo2);
        Destroyer destroyer = new Destroyer();
        destroyer.updateX(immutableDemo2, 20);
        System.out.println("immutableDemo2 = " + immutableDemo2);
    }
}
