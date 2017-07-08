package com.mauricio.springapp.service;

import java.util.List;

import com.mauricio.springapp.domain.Product;
import com.mauricio.springapp.service.ProductManager;

public class SimpleProductManager implements ProductManager {

	private static final long serialVersionUID = 1L;
	
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void increasePrice(int percentage) {
		if(products != null){
			for(Product product : products){
				double newPrice = product.getPrice().doubleValue()
						* (100 + percentage) / 100;
				product.setPrice(newPrice);
			}
		}
	}	

}
