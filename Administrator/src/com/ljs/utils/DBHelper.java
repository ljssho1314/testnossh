package com.ljs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ׼�����ݿ����ӻ���
 * @author lenovo
 *
 */
public class DBHelper {
	
	//���ݿ������ַ���
	static final String driver= "com.mysql.jdbc.Driver";
	//���ݿ�����
	static final String dbName = "java_1009";
	//�û���
	static final String uname  ="root";
	//�û�����
	static final String upass = "123456";
	//���ݿ����ӵ�ַ
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
	 * ���޲ι��췽��˽�л�����ֹ�����ഴ��new����
	 */
	private DBHelper(){}
	
	
	private static DBHelper dbHelper = null;
	
	/*
	 * ͨ����ǰ�����õ���ǰ��ʵ��
	 */
	public static synchronized DBHelper getDBHelper(){
		
		if(dbHelper==null)
		{
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}
	
	/*
	 * �õ����Ӷ���
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
	 * �ر�����
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
