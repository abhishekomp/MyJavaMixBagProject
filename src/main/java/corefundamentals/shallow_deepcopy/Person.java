package corefundamentals.shallow_deepcopy;

public class Person {


    private final Name name;
    private final Address address;

    public Person(Name name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Person(Person person){
        this(person.getName(), person.getAddress());
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    private static class Name{
        private String firstName;
        private String lastName;

        private Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

    }

    private static class Address {

    }

}
