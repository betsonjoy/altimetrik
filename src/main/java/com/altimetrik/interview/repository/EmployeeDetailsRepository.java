package com.altimetrik.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.interview.model.Employee;

@Repository
public interface EmployeeDetailsRepository  extends JpaRepository<Employee, String>{
	public List<Employee> findAllByProjectProjectId(String prjId);
	
	public Employee findByEmployeeIdAndProjectProjectId(String empId,String prjId);
}
