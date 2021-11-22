package com.altimetrik.interview.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrganizationRestErrorAdvice {

	private static final Logger logger = LoggerFactory.getLogger(OrganizationRestErrorAdvice.class);

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public void handleException(Exception exp) {
		logger.error("Exception occure with status {} caused By{}", HttpStatus.INTERNAL_SERVER_ERROR, exp.getMessage());
	}

	@ExceptionHandler({ OrganizationRestException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public void handleAODSRestException(OrganizationRestException aodsRestException) {
		logger.error("Exception occure with status {} caused By{}", HttpStatus.INTERNAL_SERVER_ERROR,
				aodsRestException.getMsg());
	}

}
