package com.ljs.test;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ljs.model.Dept;
import com.ljs.model.Emp;
import com.ljs.model.User;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session  = null;
		Session session1  = null;
		try {
		    session = HibernateUtil.getSession();  
		    User  u = (User)session.get(User.class,8);
			System.out.println(u.getuName()+"  "+u);
			User  u1 = (User)session.get(User.class,8);
			System.out.println(u1.getuName()+"  "+u1);
			session1 = HibernateUtil.getSession();   
			User  u2 = (User)session1.get(User.class,8);
			System.out.println("aaaaaa"+u2.getuName()+"  "+u2);
		} catch (HibernateException e) {
		    e.printStackTrace();
		} finally{
		    session.close();  
		    session1.close();  

		}
	}

}
