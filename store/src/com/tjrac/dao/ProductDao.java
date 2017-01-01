package com.tjrac.dao;

import java.util.List;

import com.tjrac.domain.Product;

public interface ProductDao {

	public List<Product> findAll();

	public Product findById(String id);

	/**
	 * �۳���Ʒ�Ŀ����Ϣ
	 * @param product_id
	 * @param buynum
	 */
	public void delPnum(String product_id, Integer buynum);

}
