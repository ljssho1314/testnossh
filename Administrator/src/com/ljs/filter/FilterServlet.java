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
		System.out.println("ִ�й�����");
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		request.setCharacterEncoding(charset);//�����������Ϊuft-8��ʽ��ȡ
		response.setCharacterEncoding(charset);//������Ӧ����Ϊuft-8��ʽ��ȡ
		response.setContentType("text/html;charset="+charset);//������ҳ��ʱ��uft-8��ȡ
//		HttpSession session = request.getSession();
//		User user = (User)session.getAttribute("user");
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
//		String cons = "/login.jsp,/login,/loginout.jsp";//��ӹ����ַ���
//		if(cons.indexOf(servletPath)==-1)
//		{
//			if(user==null)
//			{
//				arg1.setContentType("text/html;charset="+charset);//������ҳ��ʱ��uft-8��ȡ
//				response.getWriter().write("<script>alert('����δ��¼�����߻Ự���ڣ����µ�¼');window.location.href='./login.jsp';</script>");
//			}else
//			{
//				arg2.doFilter(arg0, arg1);//һ������	
//			}
//		}else
//		{
//			arg2.doFilter(arg0, arg1);//һ������	
//		}	
		arg2.doFilter(arg0, arg1);//һ������	

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		charset = arg0.getInitParameter("charset");
		System.out.println("��ʼ���������������ַ�����"+charset);
	}

}
