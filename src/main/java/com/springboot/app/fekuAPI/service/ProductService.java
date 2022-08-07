package com.springboot.app.fekuAPI.service;

import com.springboot.app.fekuAPI.model.Product;
import com.springboot.app.fekuAPI.model.SingleMessage;

import java.util.List;

public interface ProductService {


    List<Product> getProducts();

    void deleteAllProductSchedulerJob();

    void generateNewProductsDataScheduler(List<Product> productsList);

    Product getProductById(Long id);

    Product updateProductById(Long id, Product product);

    SingleMessage deleteProduct(Long id);
}
