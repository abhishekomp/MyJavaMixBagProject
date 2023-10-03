package java8practice.personwithhobby;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final int age;
    private List<Hobby> hobbies = new ArrayList<>();

    public Person(String name, int age, List<Hobby> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
