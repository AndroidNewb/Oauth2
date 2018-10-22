package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}