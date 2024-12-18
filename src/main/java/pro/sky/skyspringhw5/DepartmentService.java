package pro.sky.skyspringhw5;


import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalaryByDept(Integer department) {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees != null) {
            return employees.stream()
                    .filter(employee -> employee.getDepartment().equals(department))
                    .max(Comparator.comparingInt(Employee::getDepartment))
                    .orElse(null);
        } else {
            return null;
        }
    }

    public Employee getEmployeeWithMinSalaryByDept(Integer department) {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees != null) {
            return employees.stream()
                    .filter(employee -> employee.getDepartment().equals(department))
                    .min(Comparator.comparingInt(Employee::getDepartment))
                    .orElse(null);
        } else {
            return null;
        }
    }

    public Map<Integer, List<Employee>> getAllEmployeesByDepartment(Integer department) {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees != null) {
            return employees.stream()
                    .filter(employee -> employee.getDepartment().equals(department))
                    .collect(Collectors.groupingBy(Employee::getDepartment));
        } else {
            return null;
        }
    }

    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        List<Employee> employees = employeeService.getAllEmployees();
        if (employees != null) {
            return employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));
        } else {
            return null;
        }
    }
}
