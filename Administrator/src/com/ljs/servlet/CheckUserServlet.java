package com.ljs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljs.model.User;
import com.ljs.service.UserService;
import com.ljs.service.impl.UserServiceImpl;

public class CheckUserServlet extends HttpServlet {

	private UserService us = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		User u = us.checkUser(uname);
		if(u!=null)
		{
			resp.getWriter().println("no");
		}else
		{
			resp.getWriter().println("ok");
		}
	}

	
	

}
