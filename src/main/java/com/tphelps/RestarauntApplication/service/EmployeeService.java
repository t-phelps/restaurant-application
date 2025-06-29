package com.tphelps.RestarauntApplication.service;

import com.tphelps.RestarauntApplication.model.Employee;
import com.tphelps.RestarauntApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {

    public EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeByFirstName(String firstName) throws ChangeSetPersister.NotFoundException {
        return employeeRepository.findByFirstName(firstName)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Employee getEmployeeById(String id) throws ChangeSetPersister.NotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Employee deleteEmployeeByFirstName(String firstName) throws ChangeSetPersister.NotFoundException {
       return  employeeRepository.deleteByFirstName(firstName)
               .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll().stream().sorted().toList();

    }

    public double getTotalSalaries(){
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().mapToDouble(Employee::getSalary).sum();
    }

}
