package com.fx.dao;

import java.util.List;

import com.fx.beans.User;
import com.fx.utils.Page;

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

	/**
	 * 根据用户名查用户
	 * @param uname
	 * @return
	 */
	public User findByUname(String uname);

	/**
	 * 查询所有的员工 ，不包括管理员
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 插入一条员工数据
	 * @param uname
	 * @param md5
	 */
	public void addUser(String uname, String md5);

	/**
	 * 指定的id删除员工
	 * @param uid
	 */
	public void delStaff(Integer uid);

	/**
	 * 根据用户id查找用户
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
