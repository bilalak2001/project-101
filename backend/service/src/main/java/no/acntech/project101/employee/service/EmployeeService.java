package no.acntech.project101.employee.service;

import java.util.List;
import java.util.Optional;

import no.acntech.project101.company.Company;
import no.acntech.project101.company.consumer.BrregRestClient;
import no.acntech.project101.company.repository.CompanyRepository;
import no.acntech.project101.employee.Employee;
import no.acntech.project101.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
        private final EmployeeRepository employeeRepository;

    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(final Employee employee) {
        //TODO
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(final Long id) {
        //TODO
        return employeeRepository.findById(id);
    }

    public List<Employee> findAll() {
        //TODO
        return employeeRepository.findAll();
    }

    public void delete(final Long id) {
        //TODO
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }
    }
}





