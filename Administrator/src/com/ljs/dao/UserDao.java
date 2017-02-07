package com.ljs.dao;

import java.sql.SQLException;
import java.util.List;

import com.ljs.model.User;

public interface UserDao {

	
	/*
	 * �������ݿ�
	 */
	public int insertUser(User u) throws SQLException ;
	
	/*
	 * �޸�
	 */
	
	public int updateUser(User u,User u1) throws SQLException;
	
	/*
	 * ɾ��
	 */
	public int deleteUser(User u) throws SQLException;
	
	/*
	 * ��ѯ
	 */
	public List<User> selectAll(String uname) throws SQLException;
	
	
	/*
	 * �õ����id
	 */
	public int  getMaxId()  throws SQLException;
	
	/*
	 * �����û���Ϣ��ѯ�û�
	 */
	public User getUser(User u) throws SQLException;
	
	/*
	 * �����û�id��ѯ�û�ϸ��
	 */
	public User getUser(int id) throws SQLException;
	
	public User checkUser(String uname) throws SQLException;
}
