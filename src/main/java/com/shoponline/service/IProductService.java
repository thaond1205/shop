package com.shoponline.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shoponline.entities.Product;

public interface IProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String id);
	
	Product create(Product product);
	
	Product update(Product product);
	
	void delete(Integer id);
	
	Page<Product> findPaginated(Integer pageNo, Integer pageSize);
	
	List<Product> findByNameProduct(String nameSearch);
}
