package com.mauricio.springapp.service;

import java.io.Serializable;
import java.util.List;

import com.mauricio.springapp.domain.Product;

public interface ProductManager extends Serializable {

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();

}
