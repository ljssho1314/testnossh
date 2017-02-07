package com.ljs.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ljs.model.DeptEmp;

public class Test {

	public static void main(String[] args) {
		Session session = null;
		Session session2 = null;

		Transaction tx = null;
		try {
			session =HibernateUtil.getSession();
			/*
			 *  ʹ��hql����ѯ���ݿ�
			 */
			String hql = "select new com.ljs.model.DeptEmp(d.deptName,e.name,e.sex) from Dept d,Emp e where d.deptNo = e.deptno";
			Query q = session.createQuery(hql);
			List<DeptEmp> ls = q.list();
			for(DeptEmp o:ls)
			{
				System.out.println(o.getDeptName()+"  "+o.getName()+"  "+o.getSex());
			}
			
//			String sql = "select d.deptname,e.name,e.sex from dept d,emp e where d.deptno = e.dept";
//			Query q = session.createSQLQuery(sql).addEntity(Dept.class).addEntity(Emp.class);
//			List<Dept> ls = q.list();
//			for(Dept e:ls)
//			{
//				System.out.println(e.get);
//			}
//			
//			Dept d = (Dept)session.get(Dept.class, 789);
//			System.out.println(d.getDeptName());
//			for(Emp e:d.getEmps())
//			{
//				System.out.println(e.getName());
//			}
//			Emp emp = (Emp)session.get(Emp.class, 7);
//			System.out.println(emp.getName()+"   "+emp.getDeptM().getDeptName());
//			tx = session.beginTransaction();
//			
//			String hql = "from User as  u where u.uname = ? and upass=?";
//			
//			Query q = session.createQuery(hql);
//			q.setString(0, "��������");
//			q.setString(1, "888888");
//			List<User> ls  = q.list();
//			
//			for(User u:ls)
//			{
//				System.out.println(u.getUname());
//			}
//			String countHql = "select count(*) from User";
//			Long long1 = (Long)(session.createQuery(countHql).uniqueResult());
//			System.out.println(long1.intValue());
//			int pages = 2;//ҳ����
//			int count = 2;//ÿҳ��ʾ��Ŀ
//			String hql = "from User";//׼��Ҫ��ѯ��hql���
//			Query q = session.createQuery(hql);
//			q.setMaxResults(count);//׼��ÿҳ��ʾ��Ŀ
//			q.setFirstResult((pages-1)*count);//����ҳ�������ǰҳ��ʾ��¼
////			q.setMaxResults(2);//׼��ÿҳ��ʾ��Ŀ
////			q.setFirstResult(2);//����ҳ�������ǰҳ��ʾ��¼
//			List<User> ls = q.list();
//			for(User u:ls)
//			{
//				System.out.println(u.getUname());
//			}
 //			User user = new User();
//			user.setId(22);
//			user.setUname("��������");
//			user.setUpass("888888");
//			user.setAge("18");
//			user.setPhone("138888888");
//			session.save(user);
//			User  u = (User)session.get(User.class,22);
//			System.out.println(u.getUname());
//			User  u1 = (User)session.get(User.class,23);
//			System.out.println(u1.getUname());
//			System.out.println("==================================");
//			session2 = HibernateUtil.getSession();
//			User  u2= (User)session2.get(User.class,24);
//			System.out.println(u2.getUname());
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
