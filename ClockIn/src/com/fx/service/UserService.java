package com.fx.service;

import com.fx.beans.User;



public interface UserService {
	/**
	 * 用户注册
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User login(String name, String pwd);

	/**
	 * 修改用户的密码
	 * @param user
	 */
	public void updatePwd(User user);
}
