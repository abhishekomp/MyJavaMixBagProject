package corefundamentals.equalshashcode_and_sort;

import java.util.Comparator;
import java.util.Objects;

/**
 * Demonstrates the importance of overriding equals() and hashCode() methods when comparing 2 instances of the object.
 * Demonstrates the importance of implementing Comparable interface used when trying to sort the instances of the object
 */
public class Employee implements Comparable<Employee>{
    private final String firstName;
    private final String lastName;
    private final int age;
    private final double salary;

    public Employee(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public int compareTo(Employee other) {
        // compareTo should return < 0 if "this" is supposed to be
        // less than "other", > 0 if "this" is supposed to be greater than
        // "other" and 0 if they are supposed to be equal
        int last = this.lastName.compareTo(other.lastName);
        return last == 0 ? this.firstName.compareTo(other.firstName) : last;
    }

    /**
     * Comparator used to compare instances of Employee class based on age(int) value
     */
    public static Comparator<Employee> COMPARE_BY_AGE = new Comparator<Employee>() {

        @Override
        public int compare(Employee emp1, Employee emp2) {
            return emp1.getAge() - emp2.getAge();
        }
    };

    /**
     * Comparator used to compare instances of Employee class based on age(int) value
     */
    public static Comparator<Employee> COMPARE_BY_SALARY = new Comparator<Employee>() {

        @Override
        public int compare(Employee emp1, Employee emp2) {
            return Double.compare(emp1.getSalary(), emp2.getSalary());
        }
    };

    /**
     * Comparator used to compare instances of Employee class based on age(int) value
     */
    public static Comparator<Employee> COMPARE_BY_FIRSTNAME = (Employee emp1, Employee emp2) -> emp1.getFirstName().compareTo(emp2.getFirstName());
}
