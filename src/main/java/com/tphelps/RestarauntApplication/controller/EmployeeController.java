package com.tphelps.RestarauntApplication.controller;

import com.tphelps.RestarauntApplication.model.Employee;
import com.tphelps.RestarauntApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/employee")
public class EmployeeController {

    public EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Posts {@link Employee} to the DB
     * TODO Change the argument exceptions to be custom
     * @param employee Employee object to be created
     * @return the created employee
     */
    @PostMapping("/post-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        if(employee == null){throw new IllegalArgumentException("Employee cannot be null");}
        Employee employeeSaved = employeeService.addEmployee(employee);
        return ResponseEntity.ok(employeeSaved);
    }

    /**
     * Get the employee from the DB by the provided first name of said employee
     * @param firstName First Name of employee to find
     * @return Employee object if found
     * @throws ChangeSetPersister.NotFoundException throws not found exception if employee doesn't exist in DB
     */
    @GetMapping("/get-employee/{firstName}")
    public Employee getEmployeeByFirstName(@PathVariable("firstName") String firstName) throws ChangeSetPersister.NotFoundException {
        if(firstName == null){throw new IllegalArgumentException("First Name cannot be null");}
        return employeeService.getEmployeeByFirstName(firstName);
    }

    /**
     * Get the employee from the DB by the provided ID of said employee
     * @param id ID of employee to find
     * @return Employee object if found
     * @throws ChangeSetPersister.NotFoundException throws not found exception if employee doesn't exist in DB
     */
    @GetMapping("/get-employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) throws ChangeSetPersister.NotFoundException {
        if(id == null){throw new IllegalArgumentException("Employee Id cannot be null");}
        return employeeService.getEmployeeById(id);
    }

    /**
     *
     * @param firstName
     * @return
     */
    @DeleteMapping
    public ResponseEntity<Employee> deleteEmployeeByFirstName(@RequestParam("firstName") String firstName) throws ChangeSetPersister.NotFoundException {
        if(firstName == null){throw new IllegalArgumentException("First Name cannot be null");}
        Employee employeeDeleted = employeeService.deleteEmployeeByFirstName(firstName);
        return ResponseEntity.ok(employeeDeleted);
    }

//    /**
//     *
//     * @param id
//     * @return
//     */
//    @DeleteMapping
//    public ResponseEntity<String> deleteEmployeeById(@RequestParam("id") String id) {
//        return employeeService.deleteEmployeeById(id);
//    }
//
//    /**
//     *
//     * @param id
//     * @param salary
//     * @return
//     */
//    @PatchMapping
//    public ResponseEntity<String> updateEmployeeSalaryById(@RequestParam("id") String id, @RequestParam("salary") int salary) {
//        return employeeService.updateEmployeeSalary(id, salary);
//    }
//
//    /**
//     *
//     * @param id
//     * @param jobTitle
//     * @return
//     */
//    @PatchMapping
//    public ResponseEntity<String> updateEmployeeJobTitleById(@RequestParam("id") String id, @RequestParam("jobTitle") String jobTitle) {
//        return employeeService.updateEmployeeJobTitleById(id, jobTitle);
//    }

    @GetMapping("/get-all-employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get-total-salaries")
    public double getTotalSalaries() {
        return employeeService.getTotalSalaries();
    }



}
