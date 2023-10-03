package employeetaxcalculator;

public class Employee {
    private String name;
    private int salary;
    private EmployeeType employeeType;

    public Employee(String name, int salary, EmployeeType employeeType) {
        this.name = name;
        this.salary = salary;
        this.employeeType = employeeType;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
}
