package com.fx.service;

import java.util.List;

import com.fx.beans.User;
import com.fx.utils.Page;



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

	/**
	 * 找回密码 判断用户名是否存在
	 * @param uname
	 * @return
	 */
	public User findByUname(String uname);
	
	
	/**
	 * 查询所有的员工
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 添加一个员工 添加之前要先判断这个员工是否已经存在
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public boolean addUser(String uname, String pwd);

	/**
	 * 删除指定的员工
	 * @param uid
	 */
	public void delStaff(Integer uid);

	/**
	 * 根据id查找用户
	 * @param uid
	 * @return
	 */
	public User findByUid(Integer uid);

	/**
	 * 分页
	 * @param page
	 * @return
	 */
	public List<User> findAll(Page page);
}
