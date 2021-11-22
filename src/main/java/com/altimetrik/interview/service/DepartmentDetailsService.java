package com.altimetrik.interview.service;

import com.altimetrik.interview.handler.OrganizationApiResponse;
import com.altimetrik.interview.model.DepartmentResponse;

public interface DepartmentDetailsService {

	public OrganizationApiResponse<DepartmentResponse> fetchDepartmentDetailsById(String depId);
}
