package corefundamentals.upcast_downcast;

public class AnimalRunner {
    public static void main(String[] args) {
        // This is upcast. Using "animal" reference variable you could invoke any method that is defined in the Animal class because "animal" reference type is of type "Animal"
        Animal myAnimal = new Dog();

        // The method implementation that gets executed is determined at run time based on the actual object this reference variable is pointing to.
        myAnimal.makeNoise();

        // Note: growl() method is not defined on the myAnimal type.
        //myAnimal.growl();

        Cat myCat = new Cat();
        doAnimalStuff(myCat);
    }

    public static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        // downcasting
        Dog myDog = (Dog)animal;
        myDog.growl();

        // If you are downcasting, then this is how you make sure that your method has received the memory address of the correct type of object.
        // In this case we are downcasting and we expect to receive an object of type "Dog"
        if(animal instanceof Dog) {
            Dog myDog2 = (Dog)animal;
            myDog2.growl();
        }
    }
}
