package map_related.list_to_map;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class ListToHashMap {

    private List<Person> createPeople() {
        return List.of(
                new Person("Jack", 15),
                new Person("Sara", 20),
                new Person("Bob", 20),
                new Person("Paula", 35),
                new Person("Nancy", 40),
                new Person("Tom", 36),
                new Person("Tom", 70),
                new Person("Bill", 25),
                new Person("Jill", 50),
                new Person("Tom", 60)

        );
    }

    public Map<String, Person> nameToPerson(List<Person> personList) {
        Map<String, Person> nameToPerson = personList.stream()
                .collect(toMap(Person::getName, Function.identity()));
        return nameToPerson;
    }

    public Map<String, Integer> nameToAge(List<Person> personList) {
        Map<String, Integer> nameToAge = personList.stream()
                .collect(toMap(Person::getName, Person::getAge));
        return nameToAge;
    }

    /** Create map from list and handle key clash happens
     *
     * @param personList
     * @return Map
     */
    public Map<String, Integer> nameToAgeHandleKeyClash(List<Person> personList) {
        Map<String, Integer> nameToAge = personList.stream()
                .collect(toMap(Person::getName,
                        Person::getAge,
                        (a, b) -> a
                        ));
        return nameToAge;
    }

    /** Create map from list and handle key clash happens and tell which map is required
     *
     * @param personList
     * @return
     */
    public Map<String, Integer> nameToAgeSpecifyMap(List<Person> personList) {
        Map<String, Integer> nameToAge = personList.stream()
                .collect(toMap(Person::getName,
                        Person::getAge,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        return nameToAge;
    }

    public static void main(String[] args) {
        ListToHashMap listToHashMap = new ListToHashMap();
//        Map<String, Person> stringPersonMap = listToHashMap.nameToPerson(listToHashMap.createPeople());
//        System.out.println("stringPersonMap = " + stringPersonMap);
//        System.out.println(stringPersonMap.getClass());

//        Map<String, Integer> nameToAge = listToHashMap.nameToAge(listToHashMap.createPeople());
//        System.out.println("'nameToAge' = " + nameToAge);

        // When keys care clashing
        Map<String, Integer> nameToAge = listToHashMap.nameToAgeHandleKeyClash(listToHashMap.createPeople());
        System.out.println("'nameToAge' = " + nameToAge);
        System.out.println(nameToAge.getClass());

        // When keys care clashing and also specify the map to preserve the key order
//        Map<String, Integer> nameToAge = listToHashMap.nameToAgeSpecifyMap(listToHashMap.createPeople());
//        System.out.println("'nameToAge' = " + nameToAge);   //'nameToAge' = {Jack=15, Sara=20, Bob=20, Paula=35, Nancy=40, Tom=36, Bill=25, Jill=50}
//        System.out.println(nameToAge.getClass());
    }

}
