package pro.sky.skyspringhw5;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    private final EmployeeService employeeService;


    public DepartmentController(DepartmentService departmentService,
                                EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/add-data")
    public void addDataTest() {
        employeeService.addDataTest();
        return;
    }

    @GetMapping("/max-Salary")
    public Employee getEmployeeWithMaxSalaryByDept(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalaryByDept(departmentId);
    }

    @GetMapping("/min-Salary")
    public Employee getEmployeeWithMinSalaryByDept(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeWithMinSalaryByDept(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        if (departmentId == null) {
            return departmentService.getAllEmployeesByDepartment();
        }
        return departmentService.getAllEmployeesByDepartment(departmentId);
    }
}
