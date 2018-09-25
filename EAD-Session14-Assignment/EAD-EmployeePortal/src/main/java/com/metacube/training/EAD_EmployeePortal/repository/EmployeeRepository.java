package com.metacube.training.EAD_EmployeePortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.EAD_EmployeePortal.models.Employee;

public interface EmployeeRepository<E> extends JpaRepository<Employee, Integer> {

	Employee findByEmailAndPassword(String email, String password);

	Employee findByEmail(String email);

	Employee findByfirstName(String name);

	@Modifying
	@Query("select e from JobDetails j,Employee e where e.id=j.employeeId AND j.projectId=:projectId")
	List<Employee> getByProjectId(@Param("projectId") int projectId);
}
