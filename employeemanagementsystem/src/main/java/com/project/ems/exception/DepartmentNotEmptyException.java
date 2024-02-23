package com.project.ems.exception;

public class DepartmentNotEmptyException extends Throwable {
	String msg = "";

	public DepartmentNotEmptyException(String msg) {
		this.msg = msg;

	}
}
