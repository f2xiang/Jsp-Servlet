package com.fx.dao;

import java.util.List;

import com.fx.beans.User;
import com.fx.utils.Page;

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

	/**
	 * �����û������û�
	 * @param uname
	 * @return
	 */
	public User findByUname(String uname);

	/**
	 * ��ѯ���е�Ա�� ������������Ա
	 * @return
	 */
	public List<User> findAll();

	/**
	 * ����һ��Ա������
	 * @param uname
	 * @param md5
	 */
	public void addUser(String uname, String md5);

	/**
	 * ָ����idɾ��Ա��
	 * @param uid
	 */
	public void delStaff(Integer uid);

	/**
	 * �����û�id�����û�
	 * @param uid
	 * @return
	 */
	public User findByUid(Integer uid);

	/**
	 * ��ҳ
	 * @param page
	 * @return
	 */
	public List<User> findAll(Page page);

}
