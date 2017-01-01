package com.tjrac.service;

import com.tjrac.domain.User;

public interface UserService {

	public void regist(User user);

	public User findUserByUP(String name, String pwd);

}
