package com.altimetrik.interview.handler;

public class OrganizationApiResponse<T> {
	
	private String status;

	private String statusMessage;

	private T result;
	
	public OrganizationApiResponse() {
		
	}
	
	public OrganizationApiResponse(String status, String statusMessage) {
		super();
		this.status = status;
		this.statusMessage = statusMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	

}
