package com.mauricio.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mauricio.springapp.domain.Product;
import com.mauricio.springapp.repository.ProductDao;
import com.mauricio.springapp.service.ProductManager;

public class SimpleProductManager implements ProductManager {

	private static final long serialVersionUID = 1L;
	
	@Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

	public List<Product> getProducts() {
		return productDao.getProductList();
	}

	public void increasePrice(int percentage) {
		List<Product> products = productDao.getProductList();
		if(products != null){
			for(Product product : products){
				double newPrice = product.getPrice().doubleValue()
						* (100 + percentage) / 100;
				product.setPrice(newPrice);
				productDao.saveProduct(product);
			}
		}
	}	

}
