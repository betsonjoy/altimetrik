package com.altimetrik.interview.service;

import java.util.List;

import com.altimetrik.interview.handler.OrganizationApiResponse;
import com.altimetrik.interview.model.EmpPrjResponse;
import com.altimetrik.interview.model.ProjectResponse;

public interface ProjectDetailsService {

	public OrganizationApiResponse<ProjectResponse> fetchProjectDetailsById(String prjId, String depId);
	public OrganizationApiResponse<List<EmpPrjResponse>> fetchAllEmpDetailsByProject(String prjId);
}
