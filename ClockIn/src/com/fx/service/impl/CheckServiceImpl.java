package com.fx.service.impl;

import com.fx.beans.Check;
import com.fx.dao.CheckDao;
import com.fx.dao.impl.CheckDaoImpl;
import com.fx.service.CheckService;

public class CheckServiceImpl implements CheckService{
	private CheckDao checkDao = new CheckDaoImpl();

	@Override
	public void workCard(Integer u_id) {
		// TODO Auto-generated method stub
		//�ϰ�� �����ݿ��������
		Check check =  this.checkDao.addWorkTime(u_id);
		
		//�жϴ�ʱ�� �����ݿ����򿨵����ͣ��ٵ� ������
	  //	check.getWorktime()  ��  now  ���бȽ�
		
		
		
	}
	
	
}
