package com.ljs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ljs.dao.UserDao;
import com.ljs.model.User;
import com.ljs.utils.DBHelper;

public class UserDaoImpl implements UserDao {

	private DBHelper dbh = DBHelper.getDBHelper();

	@Override
	public int insertUser(User u) throws SQLException {
		// 准备数据库环境
		String sql = "insert into user values(?,?,?,?,?)";
		// 准备链接对象
		Connection con = dbh.getConection();
		// 准备执行对象
		PreparedStatement ps = con.prepareStatement(sql);
		// 传参
		ps.setInt(1,getMaxId());
		ps.setString(2, u.getuName());
		ps.setString(3, u.getuPass());
		ps.setInt(4, u.getAge());
		ps.setString(5, u.getPhone());
		int num = ps.executeUpdate();
		// 关闭
		dbh.close(con, null, ps, null);
		return num;
	}

	@Override
	public int updateUser(User u,User u1) throws SQLException {
		String sql = "update user set ";
		if (u.getId() != 0) {
			sql += "id ="+u.getId()+",";
		}
		if (u.getuName() != null) {
			sql += "uname = '"+u.getuName()+"',";
		}
		if (u.getuPass() != null) {
			sql += "upass = '"+u.getuPass()+"',";
		}
		if (u.getAge() != 0) {
			sql += "age = "+u.getAge()+",";
		}
		if (u.getPhone() != null) {
			sql += "phone = '"+u.getPhone()+"',";
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += " where 1=1";
		if (u1.getId() != 0) {
			sql += " and id = "+u1.getId()+"";
		}
		if (u1.getuName() != null) {
			sql += " and uname = '"+u1.getuName()+"'";
		}
		if (u1.getuPass() != null) {
			sql += " and upass = '"+u1.getuPass()+"'";
		}
		if (u1.getAge() != 0) {
			sql += " and age = "+u1.getAge()+"";
		}
		if (u1.getPhone() != null) {
			sql += " and phone = '"+u1.getPhone()+"'";
		}
		Connection con = dbh.getConection();
		Statement s = con.createStatement();
		System.out.println(sql);
		int num = s.executeUpdate(sql);
		dbh.close(con, s, null, null);
		return num;
	}

	@Override
	public int deleteUser(User u1) throws SQLException {
		String sql = "delete from user";
		sql += " where 1=1";
		if (u1.getId() != 0) {
			sql += " and id = "+u1.getId()+"";
		}
		if (u1.getuName() != null) {
			sql += " and uname = '"+u1.getuName()+"'";
		}
		if (u1.getuPass() != null) {
			sql += " and upass = '"+u1.getuPass()+"'";
		}
		if (u1.getAge() != 0) {
			sql += " and age = "+u1.getAge()+"";
		}
		if (u1.getPhone() != null) {
			sql += " and phone = '"+u1.getPhone()+"'";
		}
		Connection con = dbh.getConection();
		Statement s = con.createStatement();
		System.out.println(sql);
		int num = s.executeUpdate(sql);
		dbh.close(con, s, null, null);
		return num;
	}

	
	/*
	 * 查询数据库所有对象
	 * @see com.ljs.dao.UserDao#selectAll()
	 */
	@Override
	public List<User> selectAll(String uname) throws SQLException {
		String sql = "select * from user where 1=1";
		if(uname!=null&&uname.length()!=0)
		{
			sql+=" and uname like '%"+uname+"%'";
		}
		Connection con = dbh.getConection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<User> ls = new ArrayList<User>();
		while(rs.next())
		{
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setuName(rs.getString("uname"));
			u.setuPass(rs.getString("upass"));
			u.setAge(rs.getInt("age"));
			u.setPhone(rs.getString("phone"));
			ls.add(u);
		}
		dbh.close(con, ps, ps, null);
		return ls;
	}

	public static void main(String liu[]) throws SQLException {
		UserDaoImpl udi = new UserDaoImpl();
		User u = new User();
		u.setId(5);
//		User u1 = new User();
//		u1.setuPass("b");;
//		int num = udi.insertUser(u);
		int num = udi.deleteUser(u);
		System.out.println("受影响的行数：" + num);
	}
	
	public int getMaxId() throws SQLException
	{
		String sql = "select max(ifnull(id,0)) as maxid from user";
		Connection con = dbh.getConection();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		int maxid = 0;
		if(rs.next())
		{
			maxid = rs.getInt("maxid");
		}
		return maxid+1;
	}

	@Override
	public User getUser(User u) throws SQLException {
		String sql = "select * from user where uname = ? and upass =?";
		Connection con = dbh.getConection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, u.getuName());
		ps.setString(2,u.getuPass());
		ResultSet rs = ps.executeQuery();
		User u1 = null;
		if(rs.next())
		{
			u1= new User();
			u1.setId(rs.getInt("id"));
			u1.setuName(rs.getString("uname"));
			u1.setuPass(rs.getString("upass"));
			u1.setAge(rs.getInt("age"));
			u1.setPhone(rs.getString("phone"));
		}
		return u1;
	}
	
	
	@Override
	public User getUser(int id) throws SQLException {
		String sql = "select * from user where id = ?";
		Connection con = dbh.getConection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		User u1 = null;
		if(rs.next())
		{
			u1= new User();
			u1.setId(rs.getInt("id"));
			u1.setuName(rs.getString("uname"));
			u1.setuPass(rs.getString("upass"));
			u1.setAge(rs.getInt("age"));
			u1.setPhone(rs.getString("phone"));
		}
		return u1;
	}

	@Override
	public User checkUser(String uname) throws SQLException {
		String sql = "select * from user where uname = ?";
		Connection con = dbh.getConection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1,uname);
		ResultSet rs = ps.executeQuery();
		User u1 = null;
		if(rs.next())
		{
			u1= new User();
			u1.setId(rs.getInt("id"));
			u1.setuName(rs.getString("uname"));
			u1.setuPass(rs.getString("upass"));
			u1.setAge(rs.getInt("age"));
			u1.setPhone(rs.getString("phone"));
		}
		return u1;
	}
}
