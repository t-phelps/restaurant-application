package com.tphelps.RestarauntApplication.repository;

import com.tphelps.RestarauntApplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    Optional<Employee> findByFirstName(String firstName);

    Optional<Employee> deleteByFirstName(String firstName);
}
