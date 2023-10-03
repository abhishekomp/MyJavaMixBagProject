package employeetaxcalculator;

import java.util.List;

public class PermanentEmpTacCalculator {
    public int calculateTax(List<Employee> employees) {
        final int tax = employees.stream()
                .mapToInt(Employee::getSalary)
                .map(salary -> (salary * 10) / 100)
                .sum();

        return tax;
    }
}
