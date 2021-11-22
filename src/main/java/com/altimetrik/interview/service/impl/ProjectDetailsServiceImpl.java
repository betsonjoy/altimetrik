package com.altimetrik.interview.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.interview.handler.OrganizationApiResponse;
import com.altimetrik.interview.model.EmpPrjResponse;
import com.altimetrik.interview.model.ProjectResponse;
import com.altimetrik.interview.repository.DepartmentDetailsRepository;
import com.altimetrik.interview.repository.EmployeeDetailsRepository;
import com.altimetrik.interview.repository.ProjectDetailsRepository;
import com.altimetrik.interview.service.ProjectDetailsService;
import com.altimetrik.interview.util.Constants;

@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {
	Logger logger = LoggerFactory.getLogger(ProjectDetailsServiceImpl.class);

	@Autowired
	ProjectDetailsRepository projectRepo;

	@Autowired
	DepartmentDetailsRepository depRepo;

	@Autowired
	EmployeeDetailsRepository empRepo;

	@Override
	public OrganizationApiResponse<ProjectResponse> fetchProjectDetailsById(String prjId, String depId) {
		var projectApiResponse = new OrganizationApiResponse<ProjectResponse>();
		var prjResponse = new ProjectResponse();
		try {
			logger.info("Starts fetchProjectDetailsById({},{}) ", prjId, depId);
			var prj = projectRepo.findByProjectIdAndDepartmentId(prjId, depId);
			if (Objects.nonNull(prj)) {
				prjResponse.setProjectId(prj.getProjectId());
				prjResponse.setProjectName(prj.getProjectName());
				var depOpt = depRepo.findById(prj.getDepartmentId());
				if (depOpt.isPresent()) {
					prjResponse.setDepartmentName(depOpt.get().getDepartmentName());
					var empOpt = empRepo.findById(depOpt.get().getEmployeeId());
					if (empOpt.isPresent()) {
						prjResponse.setEmployeeName(empOpt.get().getEmployeeName());
					}

				}
				projectApiResponse.setResult(prjResponse);
				projectApiResponse.setStatus(Constants.STATUS_SUCCESS);
				projectApiResponse.setStatusMessage(Constants.DEP_SUCCESS_STATUS_MSG);
			} else {
				projectApiResponse.setStatus(Constants.STATUS_SUCCESS);
				projectApiResponse.setStatusMessage(Constants.PRJ_FAILURE_STATUS_MSG);
			}
			logger.info("Ends fetchProjectDetailsById({},{}) ", prjId, depId);
		} catch (Exception exp) {
			projectApiResponse.setStatus(Constants.STATUS_FAILED);
			projectApiResponse.setStatusMessage(Constants.PRJ_EXP_STATUS_MSG);

			logger.error("Exception in fetchProjectDetailsById.", exp);
		}
		return projectApiResponse;
	}

	@Override
	public OrganizationApiResponse<List<EmpPrjResponse>> fetchAllEmpDetailsByProject(String prjId) {
		var projectApiResponse = new OrganizationApiResponse<List<EmpPrjResponse>>();

		var empPrjResponseList = new ArrayList<EmpPrjResponse>();
		try {
			logger.info("Starts fetchAllEmpDetailsByProject({}) ", prjId);
			var prjList = projectRepo.findByProjectId(prjId);
			prjList.forEach(p -> {
				var empPrjResponse = new EmpPrjResponse();
				empPrjResponse.setProjectId(p.getProjectId());
				empPrjResponse.setProjectName(p.getProjectName());
				if (Objects.nonNull(p.getEmployeeId())) {
					empPrjResponse.setEmployeeName(empRepo.findById(p.getEmployeeId()).get().getEmployeeName());
				}
				empPrjResponseList.add(empPrjResponse);
			});
			projectApiResponse.setResult(empPrjResponseList);
			projectApiResponse.setStatus(Constants.STATUS_SUCCESS);
			projectApiResponse.setStatusMessage(Constants.PRJ_EMP_SUCCESS_STATUS_MSG);
			logger.info("Ends fetchAllEmpDetailsByProject({}) ", prjId);
		} catch (Exception exp) {
			projectApiResponse.setStatus(Constants.STATUS_FAILED);
			projectApiResponse.setStatusMessage(Constants.PRJ_EMP_EXP_STATUS_MSG);

			logger.error("Exception in fetchAllEmpDetailsByProject.", exp);
		}
		return projectApiResponse;
	}

}
