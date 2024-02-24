package ke.unify.departmentservice.web.rest;

import ke.unify.departmentservice.client.EmployeeClient;
import ke.unify.departmentservice.domain.Department;
import ke.unify.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
@AllArgsConstructor
public class DepartmentResource {
    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department){
        log.info("Request to add department: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping
    public List<Department> getAll(){
        log.info("Request to get all departments");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id){
        log.info("Request to get departments by id: {}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("with-employees")
    public List<Department> getAllWithEmployees(){
        log.info("Request to get all departments wth employees");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartmentIdId(department.getId())));

        return departments;
    }
}
