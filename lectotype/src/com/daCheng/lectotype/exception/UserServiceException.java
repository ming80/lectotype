package com.daCheng.lectotype.exception;

public class UserServiceException extends RuntimeException{
	public UserServiceException(String str){
		super(str);
	}
	
	public UserServiceException(String str,Exception e){
		super(str,e);
	}
}
