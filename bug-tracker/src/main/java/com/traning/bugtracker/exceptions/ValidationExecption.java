package com.traning.bugtracker.exceptions;

public class ValidationExecption extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	String message ;

	public ValidationExecption(String str) {
		super(str);
		this.message = str;

	}
}