package com.altimetrik.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.interview.model.Department;

public interface DepartmentDetailsRepository extends JpaRepository<Department, String> {

}
