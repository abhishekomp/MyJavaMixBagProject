package corefundamentals.multithreading.mt_scenario_one;

import java.util.Set;

//https://medium.com/dev-trail/junit-and-multi-threading-scenarios-ffdc21a17282
public class PersonRepository {

    private final Set<Person> persons;

    public PersonRepository(Set<Person> persons) {
        this.persons = persons;
    }

    void persist(Person person) {
        if (persons.size() >= 10) {
//            System.out.println("Size = " + persons.size());
            throw new IllegalStateException("The repository can not handle more than 10 persons");
        }
        persons.add(person);
        System.out.println(person + " added. size = " + persons.size());
    }
}
