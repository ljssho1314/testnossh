package com.ljs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljs.model.User;
import com.ljs.service.UserService;
import com.ljs.service.impl.UserServiceImpl;

public class UserDeleteServlet extends HttpServlet {

	private UserService us = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		com.ljs.service.UserService us = new com.ljs.service.impl.UserServiceImpl();
		com.ljs.model.User u = new com.ljs.model.User();
		u.setId(Integer.parseInt(req.getParameter("id")));
		boolean bool = us.removeUser(u);
		if(bool)
		{
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else
		{
			
		}
	}
}
