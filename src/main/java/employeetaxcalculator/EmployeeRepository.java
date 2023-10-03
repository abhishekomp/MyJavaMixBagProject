package employeetaxcalculator;

import java.util.List;

public class EmployeeRepository {
    public static List<Employee> getEmployees() {
        return List.of(
                new Employee("Ram", 8008, EmployeeType.PERMANENT),
                new Employee("Mohan", 6000, EmployeeType.NONPERMANENT),
                new Employee("Shyam", 7000, EmployeeType.PERMANENT),
                new Employee("Praveen", 10000, EmployeeType.PERMANENT)
        );
    }
}
