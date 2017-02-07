package com;

public class Student {

	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
		{
			return true;
		}
		if(!(obj instanceof Student))
		{
			return false;
		}
		Student s = (Student)obj;
		return this.id.equals(s.id);
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
