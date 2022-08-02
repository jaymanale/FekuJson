package com.springboot.app.fekuAPI.service;

import com.springboot.app.fekuAPI.exception.ResourceNotFoundException;
import com.springboot.app.fekuAPI.model.Product;
import com.springboot.app.fekuAPI.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> productList = productRepository.findAll();
        Collections.sort(productList);
        return productList;
    }


    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product is not found with id : '"+id+"'"));

    }

    @Override
    public Product updateProductById(Long id, Product product) {
        Product existingProduct = getProductById(id);

        existingProduct.setProductName(product.getProductName());
        existingProduct.setColor(product.getColor());
        existingProduct.setMaterial(product.getMaterial());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setPromotionCode(product.getPromotionCode());
        existingProduct.setDepartment(product.getDepartment());

        return productRepository.save(existingProduct);

    }


    // Scheduler
    @Override
    public void deleteAllProductSchedulerJob() {
        productRepository.deleteAll();
    }

    @Override
    public void generateNewProductsDataScheduler(List<Product> productsList) {
        productRepository.saveAll(productsList);
    }

}
