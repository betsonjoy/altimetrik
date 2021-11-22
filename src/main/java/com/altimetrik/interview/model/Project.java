package com.altimetrik.interview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "project_id")
	private String projectId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "department_id")
	private String departmentId;

	@Column(name = "employee_id")
	private String employeeId;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Project that = (Project) o;
		
		if (id != that.id) {
			return false;
		}
		if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) {
			return false;
		}
		if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) {
			return false;
		}
		if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) {
			return false;
		}
		return employeeId != null ? !employeeId.equals(that.employeeId) : that.employeeId != null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
		result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
		result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
		result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
		return result;
	}
}
