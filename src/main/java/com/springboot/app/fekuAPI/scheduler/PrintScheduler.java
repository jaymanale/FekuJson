package com.springboot.app.fekuAPI.scheduler;

import com.springboot.app.fekuAPI.data.ProductData;
import com.springboot.app.fekuAPI.data.UserData;
import com.springboot.app.fekuAPI.model.Product;
import com.springboot.app.fekuAPI.model.User;
import com.springboot.app.fekuAPI.service.ProductService;
import com.springboot.app.fekuAPI.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
public class PrintScheduler {

    Logger logger = LoggerFactory.getLogger(PrintScheduler.class);
    private final UserService userService;
    private final ProductService productService;

    public PrintScheduler(UserService userService, ProductService productService) {

        this.userService = userService;
        this.productService = productService;
    }

    // Scheduler to Delete and Add all user records
    // cron = "0 0 * ? * *" - To run scheduler every Hour
    // cron = "0 * * ? * *" - To run scheduler every Minute
    @Scheduled(cron = "0 0 * ? * *") // run scheduler every Hour
    public void UserRecordScheduler() {
        // Delete existing user records
        userService.deleteAllUserSchedulerJob();
        logger.info("deleteAllUserSchedulerJob() Scheduler run time is :: " + Calendar.getInstance().getTime());

        // Call UserData Util function to get all newly generated user records
        List<User> userList = UserData.generateUserData(10);

        // save newly generated user records to database
        userService.generateNewUserDataScheduler(userList);
        logger.info("generateNewUserDataScheduler() Scheduler run time is :: " + Calendar.getInstance().getTime());

    }

    @Scheduled(cron = "0 0 * ? * *") // run scheduler every Hour
    public void productRecordScheduler() {
        // Delete existing user records
        productService.deleteAllProductSchedulerJob();
        logger.info("deleteAllProductSchedulerJob() Scheduler run time is :: " + Calendar.getInstance().getTime());

        // Call UserData Util function to get all newly generated user records
        List<Product> productsList = ProductData.generateProductData(50);

        // save newly generated user records to database
        productService.generateNewProductsDataScheduler(productsList);
        logger.info("generateNewProductsDataScheduler() Scheduler run time is :: " + Calendar.getInstance().getTime());

    }


}
