package com.example.soapws.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soapws.model.Product;
import com.example.soapws.services.ProductService;

import allapis.springbootsoap.com.AddProductRequest;
import allapis.springbootsoap.com.AddProductResponse;
import allapis.springbootsoap.com.DeleteProductRequest;
import allapis.springbootsoap.com.DeleteProductResponse;
import allapis.springbootsoap.com.GetAllProductsResponse;
import allapis.springbootsoap.com.GetProductByIdRequest;
import allapis.springbootsoap.com.GetProductResponse;
import allapis.springbootsoap.com.ProductInfo;
import allapis.springbootsoap.com.ServiceStatus;
import allapis.springbootsoap.com.UpdateProductRequest;
import allapis.springbootsoap.com.UpdateProductResponse;

@Endpoint
public class ProductEndpoint {
	
	private static final String NAMESPACE_URL="http://com.springbootsoap.allapis";
	
	@Autowired
	ProductService productService;
	
	@PayloadRoot(namespace = NAMESPACE_URL, localPart = "addProductRequest")
	@ResponsePayload
	public AddProductResponse addProduct(@RequestPayload AddProductRequest request) {
		
		AddProductResponse response= new AddProductResponse();
		ServiceStatus servicestatus=new ServiceStatus();
		
		Product product=new Product();
		
		BeanUtils.copyProperties(request.getProductInfo(),product);
		productService.addProduct(product);
		servicestatus.setStatus("Success");
		servicestatus.setMessage("Content Added Successfully");
		response.setServiceStatus(servicestatus);
		return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URL, localPart = "getProductByIdRequest")
	@ResponsePayload
	public GetProductResponse GetProduct(@RequestPayload GetProductByIdRequest request) {
		GetProductResponse response=new GetProductResponse();
		ProductInfo productInfo=new ProductInfo();
		BeanUtils.copyProperties(productService.getProductById(request.getProductId()),productInfo);
		response.setProductInfo(productInfo);
		
		return response;
		
	}
	
	@PayloadRoot(namespace = NAMESPACE_URL, localPart = "updateProductRequest")
	@ResponsePayload
	public UpdateProductResponse updateArticle(@RequestPayload UpdateProductRequest request) {
		Product product = new Product();
		BeanUtils.copyProperties(request.getProductInfo(), product);
		productService.updateProduct(product);
    	ServiceStatus serviceStatus = new ServiceStatus();
    	serviceStatus.setStatus("SUCCESS");
    	serviceStatus.setMessage("Content Updated Successfully");
    	UpdateProductResponse response = new UpdateProductResponse();
    	response.setServiceStatus(serviceStatus);
    	return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URL, localPart = "getAllProductsRequest")
	@ResponsePayload
	public GetAllProductsResponse getAllArticles() {
		GetAllProductsResponse response = new GetAllProductsResponse();
		List<ProductInfo> productInfoList = new ArrayList<>();
		List<Product> articleList = productService.getAllProducts();
		for (int i = 0; i < articleList.size(); i++) {
		     ProductInfo ob = new ProductInfo();
		     BeanUtils.copyProperties(articleList.get(i), ob);
		     productInfoList.add(ob);    
		}
		response.getProductInfo().addAll(productInfoList);
		return response;
	}	
	
	@PayloadRoot(namespace = NAMESPACE_URL, localPart = "deleteProductRequest")
	@ResponsePayload
	public DeleteProductResponse deleteArticle(@RequestPayload DeleteProductRequest request) {
		Product product = productService.getProductById(request.getProductId());
    	        ServiceStatus serviceStatus = new ServiceStatus();
		if (product == null ) {
	    	    serviceStatus.setStatus("FAIL");
	    	    serviceStatus.setMessage("Content Not Available");
		} else {
		    productService.deleteProduct(product);
	    	    serviceStatus.setStatus("SUCCESS");
	    	    serviceStatus.setMessage("Content Deleted Successfully");
		}
    	        DeleteProductResponse response = new DeleteProductResponse();
    	        response.setServiceStatus(serviceStatus);
		return response;
	}	
}
