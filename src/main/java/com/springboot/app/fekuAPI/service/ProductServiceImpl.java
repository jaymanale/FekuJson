package com.springboot.app.fekuAPI.service;

import com.springboot.app.fekuAPI.exception.ResourceNotFoundException;
import com.springboot.app.fekuAPI.model.PostResponse;
import com.springboot.app.fekuAPI.model.Product;
import com.springboot.app.fekuAPI.model.SingleMessage;
import com.springboot.app.fekuAPI.repository.ProductRepository;
import com.springboot.app.fekuAPI.util.UtilHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public PostResponse<Product> getProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

        Sort sort = UtilHelper.getSortOrders(sortBy, sortDir);
        Pageable pageObj = PageRequest.of(pageNumber, pageSize,sort);
        Page<Product> pageableProduct = productRepository.findAll(pageObj);
        return UtilHelper.preparePostResponse(pageableProduct);

    }


    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product is not found with id : '" + id + "'"));

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

    @Override
    public SingleMessage deleteProduct(Long id) {
        getProductById(id);
        productRepository.deleteById(id);
        return new SingleMessage("Product with ID : " + id + " Deleted Successfully.");
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
