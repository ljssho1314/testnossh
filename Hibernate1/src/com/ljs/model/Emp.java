package com.ljs.model;

public class Emp {

	private int id;
	private String name;
	private String sex;
	private String phone;
	private String address;
	private double salary;
	private Dept deptM;
	private int dept;
	public Dept getDeptM() {
		return deptM;
	}
	public void setDeptM(Dept deptM) {
		this.deptM = deptM;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	private int top;
public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	//	private Dept dept;
	public int getId() {
		return id;
	}
//	public Dept getDept() {
//		return dept;
//	}
//	public void setDept(Dept dept) {
//		this.dept = dept;
//	}
	public void setId(int id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
