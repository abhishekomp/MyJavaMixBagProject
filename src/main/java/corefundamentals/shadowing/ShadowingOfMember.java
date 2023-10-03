package corefundamentals.shadowing;

//https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#inner-class-and-nested-static-class-example
public class ShadowingOfMember {
    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowingOfMember.this.x);  //this is very important
        }
    }

    public static void main(String... args) {
        ShadowingOfMember st = new ShadowingOfMember();
        ShadowingOfMember.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
