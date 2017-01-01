package com.tjrac.service;

import java.util.List;

import com.tjrac.domain.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product findById(String id);

}
