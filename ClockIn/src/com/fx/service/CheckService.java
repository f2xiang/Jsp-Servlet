package com.fx.service;

import java.util.List;
import java.util.Map;

import com.fx.beans.Check;

public interface CheckService {

	/**
	 * 上班打卡的时间
	 * @param u_id
	 */
	public void workCard(Check check);
	

	/**
	 * 下班打卡时间
	 * @param 
	 */
	public void homeCard(Check check);

	/**
	 * 查询所有的打卡记录
	 * @return
	 */
	public List<Map<String, String>> findAll();
	
	/**
	 * 查询当天的打卡记录
	 * @return
	 */
	public Check findByChecktime();
	
	/**
	 * 更新 下班的打卡  是一条打卡记录完整
	 * @param check
	 */
	public void updateHome(Check check);
	
	
	/**
	 * 根据id删除一条打卡记录
	 * @param cid
	 */
	public void delByCid(Integer cid);


	/**
	 * 条件查询
	 * @param time
	 * @return
	 */
	public List<Map<String, String>> findByChecktime(String time);




}
