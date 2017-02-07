package com.ljs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljs.model.User;

public class FilterServlet implements Filter{
	private String charset;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("执行过滤器");
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		request.setCharacterEncoding(charset);//设置请求参数为uft-8格式读取
		response.setCharacterEncoding(charset);//设置相应参数为uft-8格式读取
		response.setContentType("text/html;charset="+charset);//设置网页打开时以uft-8读取
//		HttpSession session = request.getSession();
//		User user = (User)session.getAttribute("user");
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
//		String cons = "/login.jsp,/login,/loginout.jsp";//添加过滤字符串
//		if(cons.indexOf(servletPath)==-1)
//		{
//			if(user==null)
//			{
//				arg1.setContentType("text/html;charset="+charset);//设置网页打开时以uft-8读取
//				response.getWriter().write("<script>alert('您尚未登录，或者会话过期，重新登录');window.location.href='./login.jsp';</script>");
//			}else
//			{
//				arg2.doFilter(arg0, arg1);//一定加上	
//			}
//		}else
//		{
//			arg2.doFilter(arg0, arg1);//一定加上	
//		}	
		arg2.doFilter(arg0, arg1);//一定加上	

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		charset = arg0.getInitParameter("charset");
		System.out.println("初始化过滤器，加载字符集："+charset);
	}

}
