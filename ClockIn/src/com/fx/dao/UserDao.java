package com.fx.dao;

import com.fx.beans.User;

public interface UserDao {

	/**
	 * �����û�������������û�
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User findUserByUP(String name, String pwd);

	/**
	 * �޸�����
	 * @param user
	 */
	public void updatePwd(User user);

}
