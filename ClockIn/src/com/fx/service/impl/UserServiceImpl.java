package com.fx.service.impl;

import com.fx.beans.User;
import com.fx.dao.UserDao;
import com.fx.dao.impl.UserDaoImpl;
import com.fx.service.UserService;
import com.fx.utils.MD5Utils;

public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User login(String name, String pwd) {
		return this.userDao.findUserByUP(name, MD5Utils.md5(pwd));
	}

	@Override
	public void updatePwd(User user) {
		user.setNewPassword(MD5Utils.md5(user.getNewPassword()));
		this.userDao.updatePwd(user);
	}

}
