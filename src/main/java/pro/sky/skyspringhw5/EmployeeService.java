package pro.sky.skyspringhw5;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private Map<String, Employee> employees;

    public EmployeeService() {
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        String fullName = employee.getFullName();
        employees.put(fullName, employee);
    }

    public void removeFullName(String fullMane) {
        String fullName1 = fullMane;
        employees.remove(fullName1);
    }

    public Employee findEmployee(String fullName) {
        return employees.get(fullName);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public void addDataTest() {
        employees.put("Айзек Азимов", new Employee("Айзек Азимов", 1, 5_000));
        employees.put("Стивен Кинг", new Employee("Стивен Кинг", 3, 15_000));
        employees.put("Артур Пирожков", new Employee("Артур Пирожков", 4, 20_000));
    }
}
