package com.shoponline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoponline.entities.Product;
import com.shoponline.reposiitories.ProductRepository;
import com.shoponline.service.IProductService;

@Service
public class ProductService implements IProductService{
	
	
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	@Override
	public Product findById(Integer id) {
		return productRepository.findById(id).get();
	}
	@Override
	public List<Product> findByCategoryId(String id) {
		// TODO Auto-generated method stub
		return productRepository.findByCategoryId(id);
	}
	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}
	@Override
	public Product update(Product product) {
		return productRepository.save(product);
	}
	@Override
	public void delete(Integer id) {
		productRepository.deleteById(id);
		
	}
	@Override
	public Page<Product> findPaginated(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return productRepository.findAll(pageable);
	}
	@Override
	public List<Product> findByNameProduct(String nameSearch) {
		return productRepository.finbByNameProduct(nameSearch);
	}
	

}
