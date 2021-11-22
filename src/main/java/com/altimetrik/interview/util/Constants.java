package com.altimetrik.interview.util;

public class Constants {

	private Constants() {

	}
	
	public static final String STATUS_SUCCESS = "SUCCESS";
	public static final String STATUS_FAILED = "FAILED";
	
	public static final String  EMP_SUCCESS_STATUS_MSG= "Successfully fetched employee details";
	public static final String  EMP_DISSOCIATE_STATUS_MSG= "Successfully dissocated employee from project";
	public static final String  EMP_DISSOCIATE_EXP_STATUS_MSG= "Exception occured while dissociation an employee from a project";
	public static final String  EMP_EXP_STATUS_MSG= "Exception occured while fetching employee details";
	public static final String  EMP_FAILURE_STATUS_MSG= "Employee with given id does not exists";
	
	public static final String  DEP_SUCCESS_STATUS_MSG= "Successfully fetched department details";
	public static final String  DEP_EXP_STATUS_MSG= "Exception occured while fetching department details";
	public static final String  DEP_FAILURE_STATUS_MSG= "Department with given id does not exists";
	
	public static final String  PRJ_SUCCESS_STATUS_MSG= "Successfully fetched project details";
	public static final String  PRJ_EXP_STATUS_MSG= "Exception occured while fetching project details";
	public static final String  PRJ_FAILURE_STATUS_MSG= "Project with given project id and department id does not exists";
	
	public static final String  PRJ_EMP_SUCCESS_STATUS_MSG= "Successfully fetched all employee details associated to the given project";
	public static final String  PRJ_EMP_EXP_STATUS_MSG= "Exception occured while fetching  all employee details associated to the given project";
}
