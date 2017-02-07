package com.ljs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 准备数据库链接环境
 * @author lenovo
 *
 */
public class DBHelper {
	
	//数据库驱动字符串
	static final String driver= "com.mysql.jdbc.Driver";
	//数据库名称
	static final String dbName = "java_1009";
	//用户名
	static final String uname  ="root";
	//用户密码
	static final String upass = "123456";
	//数据库链接地址
	static final String url = "jdbc:mysql://localhost:3306/"+dbName;
	
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 把无参构造方法私有化（防止其他类创建new对象）
	 */
	private DBHelper(){}
	
	
	private static DBHelper dbHelper = null;
	
	/*
	 * 通过当前类名得到当前类实例
	 */
	public static synchronized DBHelper getDBHelper(){
		
		if(dbHelper==null)
		{
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}
	
	/*
	 * 得到链接对象
	 */
	public Connection getConection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,uname,upass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	/*
	 * 关闭链接
	 */
	
	public void close(Connection con,Statement st,PreparedStatement ps,ResultSet rs) throws SQLException
	{
		
		if(con!=null)
		{
			con.close();
		}
		if(st!=null)
		{
			st.close();
		}
		if(ps!=null)
		{
			ps.close();
		}
		if(rs!=null)
		{
			rs.close();
		}
		
	}
	
}
