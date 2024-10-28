package com.infy.exception;

import lombok.Data;

@Data
public class ApiError {
	
	Integer ErrorCode;
	String Massage;
	
	public Integer getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(Integer errorCode) {
		ErrorCode = errorCode;
	}
	public String getMassage() {
		return Massage;
	}
	public void setMassage(String massage) {
		Massage = massage;
	}
	
	
	
}
