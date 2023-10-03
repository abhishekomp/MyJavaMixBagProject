package misc;

public class Animal {
    public int weight;

    public Animal(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class AnimalRunner {
    public static void main(String[] args) {
        Animal animal = new Animal(100);
        System.out.println("Weight at start is " + animal.getWeight());
        animal.weight = 120;
        System.out.println("Weight now is " + animal.getWeight());
    }
}

