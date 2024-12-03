package com.learn.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByProductpriceLessThan(int price);
	
	List<Product> findByProductpriceGreaterThan(int price);
	
	List<Product> findByProductpriceLessThanEqual(int price);
	
	List<Product> findByProductpriceBetween(int startPrice,int endPrice); 
	
	
}
