package no.acntech.project101.web.employee.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import no.acntech.project101.employee.Employee;
import no.acntech.project101.employee.service.EmployeeService;
import no.acntech.project101.web.employee.resources.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.acntech.project101.employee.Employee;
import no.acntech.project101.employee.service.EmployeeService;
import no.acntech.project101.web.employee.resources.converter.EmployeeConverter;
import no.acntech.project101.web.employee.resources.converter.EmployeeDtoConverter;

import static org.springframework.data.jpa.domain.JpaSort.path;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("employees")
//TODO This is a REST controler and should receive request on path employees
public class EmployeeResource<id> {

    private final EmployeeService employeeService;
    private final EmployeeConverter employeeConverter;
    private final EmployeeDtoConverter employeeDtoConverter;

    public EmployeeResource(final EmployeeService employeeService, final EmployeeConverter employeeConverter, final EmployeeDtoConverter employeeDtoConverter) {
        this.employeeService = employeeService;
        this.employeeConverter = employeeConverter;
        this.employeeDtoConverter = employeeDtoConverter;
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll() {
        //TODO create a GET endpoint find all employees in the database and return them
        final List<Employee> employees = employeeService.findAll();
        final List<EmployeeDto> collect = employees.stream()
                .map(employeeDtoConverter::convert)
                .collect(Collectors.toList());

        return ResponseEntity.ok(collect);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable final Long id) {
        // TODO create a GET endpoint that fetches a spesific employee based on its ID
        final Optional<Employee> employee = employeeService.findById(id);

        if (employee.isPresent()) {
            final EmployeeDto convert = employeeConverter.convert(employee.get());
            return ResponseEntity.ok(convert);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity createEmployee(@RequestBody final EmployeeDto employeeDto) {
        //TODO Create a POST endpoint that accepts an employeeDTO and saves it in the database
        final URI uri =  ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(12345)
                    .toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteEmployee() {
        // TODO Create a DELETE endpoint that deletes a specific employee

        return null;
    }
    @PatchMapping
    public ResponseEntity updateEmployee() {
        //TODO Create a PATCH endpoint that updates an employee with new values
        return null;
    }
}
