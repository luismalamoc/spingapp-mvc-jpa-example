package com.mauricio.springapp.repository;

import java.util.List;

import com.mauricio.springapp.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}