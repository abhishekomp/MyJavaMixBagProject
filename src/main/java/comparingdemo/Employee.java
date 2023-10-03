package comparingdemo;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Comparable<Employee>{

    private int empNum;
    private String firstName;
    private String lastName;
    private int age;

    public Employee(int empNum, String firstName, String lastName, int age) {
        this.empNum = empNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Employee(int empNum, String firstName,  int age) {
        this.empNum = empNum;
        this.firstName = firstName;
        this.age = age;
    }

    public int getEmpNum() {
        return empNum;
    }

    public void setEmpNum(int empNum) {
        this.empNum = empNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNum=" + empNum +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<Employee> getEmployees() {
        List<Employee> col = new ArrayList<Employee>();

        col.add(new Employee(5, "Frank", 28));
        col.add(new Employee(1, "Jorge", 19));
        col.add(new Employee(6, "Bill", 34));
        col.add(new Employee(3, "Michel", 10));
        col.add(new Employee(7, "Simpson", 8));
        col.add(new Employee(4, "Clerk",16 ));
        col.add(new Employee(8, "Lee", 40));
        col.add(new Employee(2, "Mark", 30));

        return col;
    }

    public static List<Employee> getFourEmployees() {
        List<Employee> col = new ArrayList<Employee>();

        col.add(new Employee(1, "Jorge", 19));
        col.add(new Employee(3, "Michel", 40));
        col.add(new Employee(4, "Xavier", 50));
        col.add(new Employee(2, "Michel", 30));

        return col;
    }

    @Override
    public int compareTo(Employee o) {

        return this.getEmpNum() - o.getEmpNum();
        //return o.getEmpNum() - this.getEmpNum();
    }
}
