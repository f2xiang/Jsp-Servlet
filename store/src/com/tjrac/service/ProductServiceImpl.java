package com.tjrac.service;

import java.util.List;

import com.tjrac.dao.ProductDao;
import com.tjrac.domain.Product;
import com.tjrac.factory.BasicFactory;

public class ProductServiceImpl implements ProductService{

	ProductDao dao = BasicFactory.getFactory().getInstance(ProductDao.class);
	
	@Override
	public List<Product> findAll() {
		return this.dao.findAll();
	}

	@Override
	public Product findById(String id) {
		return this.dao.findById(id);
	}

}
