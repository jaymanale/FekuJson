package com.springboot.app.fekuAPI.service;

import com.springboot.app.fekuAPI.model.PostResponse;
import com.springboot.app.fekuAPI.model.Product;
import com.springboot.app.fekuAPI.model.SingleMessage;

import java.util.List;

public interface ProductService {


    PostResponse<Product> getProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    void deleteAllProductSchedulerJob();

    void generateNewProductsDataScheduler(List<Product> productsList);

    Product getProductById(Long id);

    Product updateProductById(Long id, Product product);

    SingleMessage deleteProduct(Long id);
}
