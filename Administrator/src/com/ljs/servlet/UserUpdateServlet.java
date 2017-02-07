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

public class UserUpdateServlet extends HttpServlet {

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
		u.setAge(Integer.parseInt(age));
		u.setPhone(phone);
		u.setId(Integer.parseInt(req.getParameter("userid")));
		User u1 = new User();
		u1.setId(Integer.parseInt(req.getParameter("userid")));
		boolean bool =us.editUser(u, u1);
		if(bool)
		{
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}
		else
		{
			//¸üÐÂÊ§°Ü
		}
		
	}
}
