package com.altimetrik.interview.model;

import java.util.List;

public class EmployeeResponse {
	
	private String employeeName;
	private String employeeId;
	private List<String> departmentName;
	private List<String> projectName;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public List<String> getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(List<String> departmentName) {
		this.departmentName = departmentName;
	}
	public List<String> getProjectName() {
		return projectName;
	}
	public void setProjectName(List<String> projectName) {
		this.projectName = projectName;
	}

}
