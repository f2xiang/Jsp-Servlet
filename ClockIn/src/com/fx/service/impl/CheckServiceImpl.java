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
		//上班打卡 往数据库插入数据
		Check check =  this.checkDao.addWorkTime(u_id);
		
		//判断打开时间 往数据库插入打卡的类型（迟到 正常）
	  //	check.getWorktime()  和  now  进行比较
		
		
		
	}
	
	
}
