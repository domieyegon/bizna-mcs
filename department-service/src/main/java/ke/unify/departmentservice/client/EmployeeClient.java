package ke.unify.departmentservice.client;

import ke.unify.departmentservice.domain.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {
    @GetExchange("/employees/departments/{departmentId}")
    List<Employee> findByDepartmentIdId(@PathVariable("departmentId") Long departmentId);
}
