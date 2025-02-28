package com.example.soapws.services;


import java.util.List;

import com.example.soapws.model.Product;

public interface ProductService {
	
	void addProduct(Product product);
	
	Product getProductById(long productId);
	
	void updateProduct(Product product);

	List<Product> getAllProducts();
	
	void deleteProduct(Product product);
	

}
