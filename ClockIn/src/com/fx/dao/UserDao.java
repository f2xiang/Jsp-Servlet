package com.fx.dao;

import com.fx.beans.User;

public interface UserDao {

	/**
	 * 根据用户名和密码查找用户
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User findUserByUP(String name, String pwd);

	/**
	 * 修改密码
	 * @param user
	 */
	public void updatePwd(User user);

}
