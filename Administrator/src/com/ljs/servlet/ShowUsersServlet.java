package com.ljs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljs.model.User;
import com.ljs.service.UserService;
import com.ljs.service.impl.UserServiceImpl;

import net.sf.json.JSONArray;

public class ShowUsersServlet extends HttpServlet {

	private UserService us = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		List<User> ls = us.queryUser(uname);
		JSONArray ja = JSONArray.fromObject(ls);
		resp.getWriter().println(ja);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	
	

}
