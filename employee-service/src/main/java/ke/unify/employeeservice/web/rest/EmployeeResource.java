package ke.unify.employeeservice.web.rest;

import ke.unify.employeeservice.domain.Employee;
import ke.unify.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
@AllArgsConstructor
public class EmployeeResource {
    private final EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        log.info("Request to add employee: {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAll(){
        log.info("Request to get all employees");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        log.info("Request to get employees by id: {}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/departments/{departmentId}")
    public List<Employee> findByDepartmentIdId(@PathVariable("departmentId") Long departmentId){
        log.info("Request to get employees by employeeId: {}", departmentId);
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
