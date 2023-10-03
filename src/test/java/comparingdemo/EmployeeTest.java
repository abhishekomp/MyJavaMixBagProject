package comparingdemo;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void sort_Employees_using_empNumber() {
        List<Employee> employees = Employee.getEmployees();
        Collections.sort(employees);
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Jorge");
    }

    @Test
    public void sort_Four_Employees_using_empNumber() {
        List<Employee> employees = Employee.getFourEmployees();
        Collections.sort(employees);
        System.out.println("Employees sorted by emp num");
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Jorge");
    }

    @Test
    public void sort_in_DescendingOrder_Four_Employees_using_empNumber() {
        List<Employee> employees = Employee.getFourEmployees();
        Collections.reverse(employees);
        System.out.println("Employees sorted by emp num");
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Jorge");
    }

    @Test
    public void sort_Employees_using_firstName() {
        List<Employee> employees = Employee.getFourEmployees();
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
               return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Jorge");
    }

    @Test
    public void sort_Employees_using_firstName_usingLambda() {
        List<Employee> employees = Employee.getFourEmployees();
        //Collections.sort(employees, (Employee o1, Employee o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        //employees.sort((Employee o1, Employee o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        employees.sort((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Jorge");
    }

    @Test
    public void sort_Employees_using_firstName_and_then_by_age_usingLambda() {
        List<Employee> employees = Employee.getFourEmployees();
        //Collections.sort(employees, (Employee o1, Employee o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        //employees.sort((Employee o1, Employee o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        //employees.sort((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        employees.sort(
                Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getAge)
        );
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Jorge");
    }

    @Test
    public void sort_Employees_using_firstName_in_normalOrder() {
        List<Employee> employees = Employee.getFourEmployees();
        employees.sort(
                Comparator.comparing(Employee::getFirstName)
        );
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Jorge");
    }

    @Test
    public void sort_Employees_using_firstName_in_reverseOrder() {
        List<Employee> employees = Employee.getFourEmployees();
        employees.sort(
                Comparator.comparing(Employee::getFirstName).reversed()
        );
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Tichel");
    }

    @Test
    public void sort_Employees_using_firstName_and_then_by_age_usingLambda_in_reverseOrder() {
        List<Employee> employees = Employee.getFourEmployees();
        employees.sort(
                Comparator.comparing(Employee::getFirstName)
                        .thenComparing(Comparator.comparing(Employee::getAge).reversed())
        );
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Jorge");
    }

    @Test
    public void sort_Employees_using_firstName_in_reverseOrder_version2() {
        List<Employee> employees = Employee.getFourEmployees();
        Comparator<Employee> employeeNameComparator
                = Comparator.<Employee> reverseOrder();
        employees.sort(employeeNameComparator);
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Xavier");
    }

    @Test
    public void sort_Employees_using_firstName_in_naturalOrder_version2() {
        List<Employee> employees = Employee.getFourEmployees();
        Comparator<Employee> employeeNameComparator
                = Comparator.<Employee> naturalOrder();
        employees.sort(employeeNameComparator);
        employees.stream().forEach(System.out::println);
        assertThat(employees.get(0).getFirstName()).isEqualTo("Jorge");
    }




}