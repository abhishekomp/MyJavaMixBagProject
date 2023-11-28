package corefundamentals.equalshashcode_and_sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    List<Employee> list;

    @BeforeEach
    void setUp() {
        Employee e1 = new Employee("Akshay", "Sharma", 30, 15000.0);
        Employee e2 = new Employee("Kirti", "Shree", 35, 25000.0);
        Employee e3 = new Employee("John", "Doe", 45, 60000.0);
        Employee e4 = new Employee("John", "Cena", 29, 45000.0);
        Employee e5 = new Employee("Tim", "Cook", 40, 50000.0); // duplicate element as per Class definition
        Employee e6 = new Employee("Tim", "Cook", 40, 20000.0);
        Employee e7 = new Employee("Abbey", "Cena", 40, 30000.0);

        list = List.of(e1, e2, e3, e4, e5, e6, e7);
    }

    @Test
    void test_a_set_of_employees_should_have_unique_employees() {
        //Employee e6 = new Employee("Tim", "Cook", 40, 20000.0);
        List<Employee> newList = new ArrayList<>(list);
        //newList.add(e6);
        Set<Employee> set = new HashSet<>(newList);
        set.forEach(System.out::println);
        assertEquals(6, set.size());
    }

    @Test
    void test_a_map_employee_to_age_should_have_unique_keys() {
        //Convert the list to a map
        Map<Employee, List<Integer>> ageListByEmployee = list.stream()
                .collect(groupingBy(Function.identity(), mapping(Employee::getAge, toList())));
        ageListByEmployee.forEach((key, value) -> System.out.println(key + " -> " + value));

        Employee kirti = new Employee("Kirti", "Shree", 35, 25000.0);
        assertTrue(ageListByEmployee.containsKey(kirti));
        assertIterableEquals(ageListByEmployee.get(kirti), List.of(35));

        Employee cook = new Employee("Tim", "Cook", 40, 50000.0);
        assertTrue(ageListByEmployee.containsKey(cook));
        assertIterableEquals(ageListByEmployee.get(cook), List.of(40, 40));
    }

    @Test
    void test_create_a_map_of_employee_age_by_firstName() {
        //Convert the list to a map
        Map<String, Integer> ageByFirstName = list.stream()
                .collect(toMap(
                        Employee::getFirstName,
                        Employee::getAge,
                        (age1, age2) -> age1 >= age2 ? age2 : age1
                ));
        ageByFirstName.forEach((key, value) -> System.out.println(key + " -> " + value));

    }

    @Test
    void test_compareTo_should_compare_based_on_the_definition_and_return_sorted_list() {
        List<Employee> sorted = list.stream()
                .sorted()
                .collect(toList());
        sorted.forEach(System.out::println);
        assertEquals("Abbey Cena", sorted.get(0).getFullName());
    }

    @Test
    void test_should_compare_and_return_sorted_list_in_ascending_order() {
        List<Employee> empList = new ArrayList<>(list);
        //Collections.sort(empList); //for using the natural order defined inside the Employee class
        //Collections.sort(empList, Comparator.reverseOrder());

        //Collections.sort(empList, Comparator.naturalOrder());
        empList.sort(Comparator.naturalOrder());

        //empList.sort(Comparator.naturalOrder());
        //Collections.sort(empList, Collections.reverseOrder());
        //empList.sort(Collections.reverseOrder());
        empList.forEach(System.out::println);
        assertEquals("Abbey Cena", empList.get(0).getFullName());
    }

    @Test
    void test_compareTo_should_compare_based_on_the_definition_and_return_sorted_list_in_descendingOrder() {
        List<Employee> sorted = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(toList());
        sorted.forEach(System.out::println);
        assertEquals("Kirti Shree", sorted.get(0).getFullName());
    }

    @Test
    void test_compareTo_should_return_sorted_list_in_descendingOrder() {
        List<Employee> empList = new ArrayList<>(list);
        empList.sort(Comparator.reverseOrder());
        empList.forEach(System.out::println);
        assertEquals("Kirti Shree", empList.get(0).getFullName());
    }

    @Test
    void test_sort_using_lastName_ascending() {
        //Given a list of employees, sort it using lastName in ascending order
        List<Employee> collect = list.stream()
                .sorted(comparing(Employee::getLastName))
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("John Cena", collect.get(0).getFullName());
    }

    @Test
    void test_sort_using_lastName_descending() {
        //Given a list of employees, sort it using lastName in descending order
        List<Employee> collect = list.stream()
                .sorted(comparing(Employee::getLastName).reversed())
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("Kirti Shree", collect.get(0).getFullName());
    }

    @Test
    void test_sort_using_multiple_fields() {
        //Given a list of employees, sort it using lastName in ascending order and when lastName matches then sort using salary in reversed(descending) (higher salary comes first)
        List<Employee> collect = list.stream()
                .sorted(comparing(Employee::getLastName).thenComparing(Comparator.comparing(Employee::getSalary).reversed()))
                .collect(toList());
//        List<Employee> collect = list.stream()
//                .sorted(comparing(Employee::getLastName).thenComparing(Employee::getSalary).reversed())   // Incorrect as this will reverse the entire order
//                .collect(toList());
        collect.forEach(System.out::println);
    }

    @Test
    void test_sort_using_lastName_descending_then_salary_ascending() {
        //Given a list of employees, sort it using lastName in descending order and when lastName matches then sort using salary in ascending order (lower salary comes first)
        List<Employee> collect = list.stream()
                .sorted(comparing(Employee::getLastName).reversed().thenComparing(Employee::getSalary))
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("Kirti Shree", collect.get(0).getFullName());
    }

    @Test
    void test_sort_using_age_comparator_defined_in_the_class() {
        //Given a list of employees, sort the employees based on age ascending.
        List<Employee> collect = list.stream()
                .sorted(Employee.COMPARE_BY_AGE)
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("John Cena", collect.get(0).getFullName());
    }

    @Test
    void test_sort_using_age_in_descending_by_comparator_defined_in_the_class() {
        //Given a list of employees, sort the employees based on age ascending.
        List<Employee> collect = list.stream()
                .sorted(Employee.COMPARE_BY_AGE_DESCENDING)
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("John Doe", collect.get(0).getFullName());
    }

    @Test
    void test_sort_using_age_descending_by_injecting_the_comparator() {
        //Given a list of employees, sort the employees based on age ascending.
        List<Employee> collect = list.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("John Doe", collect.get(0).getFullName());
    }

    @Test
    void test_sort_using_age_comparator_defined_directly_at_the_point_of_use() {
        //Given a list of employees, sort the employees based on age ascending.
        List<Employee> collect = list.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("John Cena", collect.get(0).getFullName());
    }

    @Test
    void test_sort_using_age_comparator_defined_directly_at_the_point_of_use_via_lambda_expression() {
        //Given a list of employees, sort the employees based on age ascending.
        List<Employee> collect = list.stream()
                .sorted((e1, e2) -> e1.getAge() - e2.getAge())
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("John Cena", collect.get(0).getFullName());
    }

    @Test
    void test_sort_using_age_comparator_defined_directly_at_the_point_of_use_via_comparingInt_descending() {
        //Given a list of employees, sort the employees based on age ascending.
        List<Employee> collect = list.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("John Doe", collect.get(0).getFullName());
    }

    @Test
    void test_sort_using_salary_comparator_defined_in_the_class() {
        //Given a list of employees, sort the employees based on age ascending.
        List<Employee> collect = list.stream()
                .sorted(Employee.COMPARE_BY_SALARY)
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("Akshay Sharma", collect.get(0).getFullName());
    }

    @Test
    void test_sort_in_descending_order_using_salary_comparator_defined_in_the_class() {
        //Given a list of employees, sort the employees based on age ascending.
        List<Employee> collect = list.stream()
                .sorted(Employee.COMPARE_BY_SALARY.reversed())
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("John Doe", collect.get(0).getFullName());
    }

    @Test
    void test_sort_using_first_name() {
        //Given a list of employees, sort the employees based on age ascending.
        List<Employee> collect = list.stream()
                .sorted(Employee.COMPARE_BY_FIRSTNAME)
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals("Abbey Cena", collect.get(0).getFullName());
    }

    @Test
    void test_sorting_when_key_field_has_null_value(){
        Employee e1 = new Employee("Akshay", "Sharma", 30, 15000.0);
        Employee e2 = new Employee("Kirti", "Shree", 35, 25000.0);
        Employee e3 = new Employee("John", "Doe", 45, 60000.0);
        Employee e4 = new Employee("John", "Cena", 29, 45000.0);
        Employee e5 = new Employee(null, "Cook", 40, 50000.0);
        list = List.of(e1, e2, e3, e4, e5);
        List<Employee> collect = list.stream()
                .sorted(Employee.COMPARE_BY_FIRSTNAME)
                .collect(toList());
        collect.forEach(System.out::println);
        assertEquals(40, collect.get(0).getAge());
    }
}