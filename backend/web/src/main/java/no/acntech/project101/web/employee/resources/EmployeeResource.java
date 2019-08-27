package no.acntech.project101.web.employee.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import no.acntech.project101.employee.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.data.jpa.domain.JpaSort.path;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("employees")
//TODO This is a REST controler and should receive request on path employees
public class EmployeeResource {

    //TODO The constructor needs to accept the required dependencies and assign them to class variables
    public EmployeeResource() {
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll() {
        //TODO create a GET endpoint find all employees in the database and return them
        EmployeeDto bilal = new EmployeeDto(12345l, "Bilal","Khan",
                LocalDate.of(1995,1, 20),777l);
        final List<EmployeeDto> liste = new ArrayList<EmployeeDto>();
        liste.add(bilal);

        return ResponseEntity.ok(liste);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findById() {
        // TODO create a GET endpoint that fetches a spesific employee based on its ID
        EmployeeDto bilal = new EmployeeDto(12345l, "Bilal","Khan",
                LocalDate.of(1995,1,20),777l);

        return ResponseEntity.ok(bilal);
    }
    @PostMapping
    public ResponseEntity createEmployee(@RequestBody final EmployeeDto) {
        //TODO Create a POST endpoint that accepts an employeeDTO and saves it in the database
        final URI uri =  ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(12345)
                    .toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteEmployee(@PathVariable final id) {
        // TODO Create a DELETE endpoint that deletes a specific employee

        return ResponseEntity.accepted().build();
    }
    @PatchMapping
    public ResponseEntity updateEmployee() {
        //TODO Create a PATCH endpoint that updates an employee with new values
        return null;
    }
}
