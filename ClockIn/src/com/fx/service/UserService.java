package com.fx.service;

import com.fx.beans.User;



public interface UserService {
	/**
	 * �û�ע��
	 * @param name
	 * @param pwd
	 * @return
	 */
	public User login(String name, String pwd);

	/**
	 * �޸��û�������
	 * @param user
	 */
	public void updatePwd(User user);
}
