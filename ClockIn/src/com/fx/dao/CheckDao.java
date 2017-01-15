package com.fx.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fx.beans.Check;

public interface CheckDao {

	/**
	 * 增加一条打卡的记录
	 * @param u_id
	 * @return
	 */
	public void addWorkTime(Check check);
	
	/**
	 * 增加一条打卡的记录
	 * @param u_id
	 * @return
	 */
	public void addHomeTime(Check check);
	
	/**
	 * 查询所有打卡记录
	 * @return
	 */
	public List<Map<String, String>> findAll();
	
	/**
	 * 查询指定用户的打卡记录
	 * @param uid
	 * @return
	 */
	public List<Check> findByUid(Integer uid);

	
	/**
	 * 删除指定id的数据
	 * @param cid
	 */
	public void delByCid(Integer cid);
	
	/**
	 * 查询当天的打卡记录
	 * @return
	 */
	public Check findByChecktime();
	
	
	
	public void updateHome(Check check);

	public List<Map<String, String>> findByChecktime(String time);

	
}
