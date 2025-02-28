package com.example.soapws.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soapws.model.Product;
import com.example.soapws.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public Product getProductById(long productId) {
		
		Product pro=productRepository.findByProductId(productId);
		return pro;
	}

	@Override
	public void updateProduct(Product product) {
		
	
		Optional<Product> product1 = productRepository.findById(product.getProductId());
		Product newEntity = product1.get();

		newEntity.setProductId(product.getProductId());
		newEntity.setProductName(product.getProductName());
		newEntity.setExpiryDate(product.getExpiryDate());
		newEntity.setPrice(product.getPrice());
		newEntity.setStock(product.getStock());
	
		
//		Product productSave = productRepository.save(newEntity);
		productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<>();
		productRepository.findAll().forEach(e -> list.add(e));
		return list;
		
	}

	@Override
	public void deleteProduct(Product product) {
		
		productRepository.delete(product);
	}

}
