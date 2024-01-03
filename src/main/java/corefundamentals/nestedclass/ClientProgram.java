package corefundamentals.nestedclass;

public class ClientProgram {
    public static void main(String[] args) {
        System.out.println("\nStatic nested class instantiation from Client Program:");
        System.out.println("--------------------");
        OuterClass.StaticNestedClass staticNestedObject = new OuterClass.StaticNestedClass();
        staticNestedObject.accessMembers(new OuterClass());

        System.out.println("\nNon-Static nested class(Inner class) instantiation from Client Program:");
        System.out.println("--------------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
    }
}
