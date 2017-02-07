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

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = null;
		Session session1  = null;
		try {
		    sessionFactory = HibernateUtil.getSessionFactory();
		    session1 = sessionFactory.openSession();   
		    User  u2 = (User)session1.get(User.class,8);
			System.out.println(u2.getuName()+"  "+u2);  
		} catch (HibernateException e) {
		    e.printStackTrace();
		} finally{
		    session1.close();
		}
	}

}
