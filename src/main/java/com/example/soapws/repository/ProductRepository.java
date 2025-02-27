package com.example.soapws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.soapws.model.Product;


public interface ProductRepository extends JpaRepository<Product,Long> {

	Product findByProductId(long productId);

}
