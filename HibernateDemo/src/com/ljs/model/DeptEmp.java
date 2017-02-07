package com.ljs.model;

public class DeptEmp {

	private String deptName;

	public DeptEmp(String deptName, String name, String sex) {
		super();
		this.deptName = deptName;
		this.name = name;
		this.sex = sex;
	}
	private String name;
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	private String sex;
	
}	
