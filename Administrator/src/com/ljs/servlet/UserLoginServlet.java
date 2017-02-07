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

public class UserLoginServlet extends HttpServlet {

	private UserService us = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		User u1 = new User();
		u1.setuName(uname);
		u1.setuPass(upass);
		User u = us.login(u1);
		HttpSession session =req.getSession();//通过请求信息得到session对象，用来封装用户信息
		if(u!=null)
		{
			session.setAttribute("user",u);
			resp.sendRedirect("index.jsp");
		}else
		{
			resp.sendRedirect("loginFail.jsp");
		}
	}
}
