package myprograms;

/**
 * Created by sca820 on 29 juni, 2022
 */
public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        Person p1 = new Person(25, "John");
        Person p2 = new Person("John", 30);
    }
}
