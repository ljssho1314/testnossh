package com.ljs.service;

import java.util.List;

import com.ljs.model.User;

public interface UserService {
	
	
	public boolean addUser(User u);
	
	public boolean editUser(User  u,User u1);
	
	public boolean removeUser(User u);
	
	public List<User> queryUser(String uname);
	
	public User login(User u);
	
	public User getUser(int id);
	
	public User checkUser(String uname);
}
