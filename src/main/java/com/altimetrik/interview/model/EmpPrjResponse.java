package com.altimetrik.interview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmpPrjResponse {
	@JsonIgnore
	private int id;
	private String projectId;
	private String projectName;
	private String employeeName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		EmpPrjResponse that = (EmpPrjResponse) o;
		
		if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) {
			return false;
		}
		if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) {
			return false;
		}
		return employeeName != null ? !employeeName.equals(that.employeeName) : that.employeeName != null;
	}

	@Override
	public int hashCode() {
		int result = projectId != null ? projectId.hashCode() : 0;
		result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
		result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
		return result;
	}
}
