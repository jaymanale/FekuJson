package com.springboot.app.fekuAPI.data;

import com.springboot.app.fekuAPI.model.Product;
import com.springboot.app.fekuAPI.util.UtilHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductData {

    public static List<Product> generateProductData(int count) {

        List<Product> productList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {

            productList.add(new Product(
                    (long) i,
                    UtilHelper.faker().commerce().productName(),
                    UtilHelper.faker().commerce().material(),
                    UtilHelper.faker().commerce().price(),
                    UtilHelper.faker().commerce().department(),
                    UtilHelper.faker().commerce().color(),
                    UtilHelper.faker().commerce().promotionCode()
            ));
        }
        return productList;

    }
}
