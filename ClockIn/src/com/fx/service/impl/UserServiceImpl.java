package com.fx.service.impl;

import java.util.List;

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

	@Override
	public User findByUname(String uname) {
		return this.userDao.findByUname(uname);
	}

	@Override
	public List<User> findAll() {
		return this.userDao.findAll();
	}

	@Override
	public boolean addUser(String uname, String pwd) {
		User user = this.userDao.findByUname(uname);
		if(user == null || "".equals(user)){
			this.userDao.addUser(uname, MD5Utils.md5(pwd));
			return true;
		}else{
			return false;
		}
		
		
	}

	@Override
	public void delStaff(Integer uid) {
		this.userDao.delStaff(uid);
	}

	@Override
	public User findByUid(Integer uid) {
		return this.userDao.findByUid(uid);
	}

	

	

}
