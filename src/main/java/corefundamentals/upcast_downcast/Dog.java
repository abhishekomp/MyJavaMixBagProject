package corefundamentals.upcast_downcast;

public class Dog extends Animal {
    @Override
    public void makeNoise(){
        System.out.println("Woof woof!");
    }

    public void growl(){
        System.out.println("Grrrrr");
    }

}
