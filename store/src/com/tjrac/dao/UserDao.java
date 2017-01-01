package com.tjrac.dao;

import com.tjrac.domain.User;

public interface UserDao {

	public User findUserByName(String username);

	public void addUser(User user);

	public User findUserByUP(String name, String pwd);

	public User findUserById(Integer user_id);

}
