package com.springboot.app.fekuAPI.controller;

import com.springboot.app.fekuAPI.model.Product;
import com.springboot.app.fekuAPI.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") Long id, @RequestBody Product product){
        return new ResponseEntity<>(productService.updateProductById(id, product),HttpStatus.OK);

    }
}
