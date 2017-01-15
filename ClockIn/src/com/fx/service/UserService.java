package com.fx.service;

import java.util.List;

import com.fx.beans.User;
import com.fx.utils.Page;



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

	/**
	 * �һ����� �ж��û����Ƿ����
	 * @param uname
	 * @return
	 */
	public User findByUname(String uname);
	
	
	/**
	 * ��ѯ���е�Ա��
	 * @return
	 */
	public List<User> findAll();

	/**
	 * ���һ��Ա�� ���֮ǰҪ���ж����Ա���Ƿ��Ѿ�����
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public boolean addUser(String uname, String pwd);

	/**
	 * ɾ��ָ����Ա��
	 * @param uid
	 */
	public void delStaff(Integer uid);

	/**
	 * ����id�����û�
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
