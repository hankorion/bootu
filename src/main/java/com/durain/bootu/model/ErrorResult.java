package com.durain.bootu.model;

public class ErrorResult extends Result<Object> {
	private String errorDetails;

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
}
