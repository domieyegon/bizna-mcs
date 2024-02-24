package ke.unify.employeeservice.repository;

import ke.unify.employeeservice.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findById(Long id) {
        return employees.stream().filter(employee -> employee.id().equals(id)).findFirst().orElseThrow();
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        return employees.stream().filter(employee -> employee.departmentId().equals(departmentId)).toList();
    }
}
