package com.springboot.app.fekuAPI.controller;

import com.springboot.app.fekuAPI.constants.Constants;
import com.springboot.app.fekuAPI.model.PostResponse;
import com.springboot.app.fekuAPI.model.Product;
import com.springboot.app.fekuAPI.model.SingleMessage;
import com.springboot.app.fekuAPI.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<PostResponse<Product>> getProducts(
            @RequestParam(value = "pageNumber", defaultValue = Constants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Constants.SORT_DIRECTION, required = false) String sortDir

    ) {
        return new ResponseEntity<>(productService.getProducts(pageNumber, pageSize, sortBy, sortDir), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProductById(id, product), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SingleMessage> deleteProduct(@PathVariable("id") Long id) {

        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}
