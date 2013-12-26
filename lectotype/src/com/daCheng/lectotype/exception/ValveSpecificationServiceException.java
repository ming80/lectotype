package com.daCheng.lectotype.exception;

public class ValveSpecificationServiceException extends RuntimeException{
	public ValveSpecificationServiceException(String str){
		super(str);
	}
	
	public ValveSpecificationServiceException(String str,Exception e){
		super(str,e);
	}
}
