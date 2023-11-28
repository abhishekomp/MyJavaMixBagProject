package java8practice;

import java.util.Objects;

public class Dog {
    private final String name;
    private final String breed;
    private final int age;

    public Dog(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return getAge() == dog.getAge() && getName().equals(dog.getName()) && getBreed().equals(dog.getBreed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBreed(), getAge());
    }
}
