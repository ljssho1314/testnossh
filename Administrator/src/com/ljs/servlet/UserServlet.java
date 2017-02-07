package com.ljs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljs.model.User;
import com.ljs.service.UserService;
import com.ljs.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	private UserService us = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		String age = req.getParameter("age");
		String phone = req.getParameter("phone");
		User u = new User();
		u.setuName(uname);
		u.setuPass(upass);
		u.setPhone(phone);
		u.setAge(Integer.valueOf(age));
		boolean bool = us.addUser(u);
		if(bool)
		{
			resp.sendRedirect("suc.jsp");
		}else
		{
			resp.sendRedirect("fail.jsp");
		}
	}

	
	

}
