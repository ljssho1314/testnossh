package com.ljs.model;

public class Emp {

	private Integer id;
	private String name;
	private String sex;
	private String phone;
	private String address;
	private Double salary;
	private Integer deptno;

	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	private Integer top;
	private Dept deptM;
	
	public Integer getId() {
		return id;
	}
	public Dept getDeptM() {
		return deptM;
	}
	public void setDeptM(Dept deptM) {
		this.deptM = deptM;
	}
	public void setId(Integer id) {
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}	
