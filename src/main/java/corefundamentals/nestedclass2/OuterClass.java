package corefundamentals.nestedclass2;

/**
 * Created on 2023-10-20
 * This demonstration shows how to create
 * Non-static nested class (aka Inner class)
 * Static nested class
 * Method local inner class
 * It then shows how to use these classes from outside (from a client program)
 */
public class OuterClass {
    private int outerNum = 6;

    public void sayHello() {
        System.out.println("Hello from Outer class");
    }

    /**
     * Non-static Nested class (aka Inner class)
     */
    public class InnerClass {
        private int innerNum = 8;

        public void whatUp(){
            System.out.println("Whats up from inner class");
        }
    }

    /**
     * Static Nested class
     */
    public static class InnerStaticClass{
        private int innerNum = 10;
        public void whatUp(){
            System.out.println("Whats up from inner static class");
        }
    }

    /**
     * Method local class
     */
    public void heyThere() {

        System.out.println("Hey there");

        /**
         * We must use this class right here. It is not accessible from outside because it is local to the method.
         */
        class LocalInnerClass {
            String localInnerClassVariable = "Here's Johnny";

            public void printLocalInnerClassVariable() {
                System.out.println(localInnerClassVariable);
            }
        }

        // Using the local Inner class from inside the method where it was defined.
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.printLocalInnerClassVariable();
    }


}
