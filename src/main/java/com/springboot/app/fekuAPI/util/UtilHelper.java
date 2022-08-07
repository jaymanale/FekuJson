package com.springboot.app.fekuAPI.util;

import com.github.javafaker.Faker;
import com.springboot.app.fekuAPI.model.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public class UtilHelper {

    public static final Faker FAKER = Faker.instance();
    public static Faker faker() {return FAKER;}

    public static <T> PostResponse<T> preparePostResponse(Page<T> pageableProduct) {
        PostResponse<T> response = new PostResponse<>();
        response.setContent(pageableProduct.getContent());
        response.setPageNumber(pageableProduct.getNumber());
        response.setPageSize(pageableProduct.getSize());
        response.setTotalElements(pageableProduct.getTotalElements());
        response.setTotalPages(pageableProduct.getTotalPages());
        response.setLastPage(pageableProduct.isLast());

        return response;
    }

    public static Sort getSortOrders(String sortBy, String sortDir) {
        Sort sort = Sort.by(sortBy).ascending();

        if (sortDir.equalsIgnoreCase("desc")) {
            sort = Sort.by(sortBy).descending();
        }
        return sort;
    }

}
