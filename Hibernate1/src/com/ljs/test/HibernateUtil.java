package com.ljs.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	
	public static SessionFactory sessionfactory = null;
	
	
		static{
		
			try{
				
				sessionfactory  = new Configuration().configure().buildSessionFactory();
				
			}catch(Throwable e)
			{
				e.printStackTrace();
			}
		
		
		}
	
	
		public static SessionFactory getSessionFactory()
		{
			return sessionfactory;
		}
	
		public static Session getSession(){
			  return  sessionfactory.openSession();
	   }
}
