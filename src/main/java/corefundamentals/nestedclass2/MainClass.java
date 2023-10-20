package corefundamentals.nestedclass2;

public class MainClass {
    public static void main(String[] args) {

//        OuterClass outerClassObj = new OuterClass();
//        outerClassObj.sayHello();

        // Creating an instance of the non-static nested class (aka inner class)
//        OuterClass.InnerClass innerClassObj = outerClassObj.new InnerClass();
//        innerClassObj.whatUp();

        // Creating an instance of the static nested class
//        OuterClass.InnerStaticClass innerStaticClassObj = new OuterClass.InnerStaticClass();
//        innerStaticClassObj.whatUp();

        // Compile error while creating an object of static inner class without using the OuterClass name
        //InnerStaticClass innerStaticClassObj = new InnerStaticClass();

        OuterClass outerClassObj = new OuterClass();
        outerClassObj.sayHello();
        outerClassObj.heyThere();

    }
}
