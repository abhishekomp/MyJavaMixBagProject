package corefundamentals;

public class DraculaPolymorphism {
    public static void main(String... doYourBest) {
        Dracula dracula = new Alucard();

        System.out.print(dracula.name + dracula.getName()); // => DraculaAlucard
        System.out.print(dracula.metamorphosis());  // => werewolf
    }

    private static class Dracula {
        String name = "Dracula";
        static String metamorphosis() {
            return "werewolf";
        }
        String getName(){
            return this.name;
        }
    }
    private static class Alucard extends Dracula {
        String name = "Alucard";
        static String metamorphosis() {
            return "bat";
        }
        String getName(){
            return this.name;
        }
    }
}
/*
https://javachallengers.com/dracula-polymorphism/
Let's analyze the code: The very first thing to notice is that we are using polymorphism on that line of the code. We are declaring the parent class but instantiating it with the child class, which enables us to use polymorphic methods:

Dracula dracula = new Alucard();

Then we will be using the name attribute but remember that attributes will never be overridden, and there is no polymorphism with attributes, only with instance methods. Therefore, the name that will be printed will be from the Dracula class since we declared the dracula variable with the type of Dracula. And the getName method will be from the Alucard class since we are using polymorphism and getName is an instance method: System.out.print(dracula.name + dracula.getName());

Therefore it will print: DraculaAlucard

Finally, we are invoking the static method. Remember that a static method is not an instance method, it's a class method and doesn't depend on an instance to work.

Therefore, polymorphism won't happen even though we use the same method name with the child class. The invoked method will be from the class we declared the dracula instance. Therefore it will be the Dracula class: System.out.print(dracula.metamorphosis());

The information from the Dracula class will be printed then: werewolf In conclusion, the final output will be: DraculaAlucardwerewolf
 */