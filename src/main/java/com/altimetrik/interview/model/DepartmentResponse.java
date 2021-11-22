package com.altimetrik.interview.model;

import java.util.List;

public class DepartmentResponse {

	private String DepartmentId;
	private String DepartmentName;
	private String employeeName;
	private List<String> projectName;
	public String getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(String departmentId) {
		DepartmentId = departmentId;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public List<String> getProjectName() {
		return projectName;
	}
	public void setProjectName(List<String> projectName) {
		this.projectName = projectName;
	}
	
}
