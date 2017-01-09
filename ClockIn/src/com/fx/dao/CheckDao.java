package com.fx.dao;

import com.fx.beans.Check;

public interface CheckDao {

	/**
	 * 增加一条打卡的记录
	 * @param u_id
	 * @return
	 */
	public Check addWorkTime(Integer u_id);

}
