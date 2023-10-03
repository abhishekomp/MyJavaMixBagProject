package employeetaxcalculator;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        final List<Employee> employees = EmployeeRepository.getEmployees();
        PermanentEmpTacCalculator calculator = new PermanentEmpTacCalculator();
        final int tax = calculator.calculateTax(employees);
        System.out.println("tax = " + tax);

    }
}
