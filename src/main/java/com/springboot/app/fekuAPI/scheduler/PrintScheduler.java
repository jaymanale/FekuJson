package com.springboot.app.fekuAPI.scheduler;

import com.springboot.app.fekuAPI.data.UserData;
import com.springboot.app.fekuAPI.model.User;
import com.springboot.app.fekuAPI.service.UserService;
import com.springboot.app.fekuAPI.util.UtilHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class PrintScheduler {

    Logger logger = LoggerFactory.getLogger(PrintScheduler.class);
    private UserService userService;

    public PrintScheduler(UserService userService) {
        this.userService = userService;
    }

    // Scheduler to Delete and Add all user records
    // cron = "0 0 * ? * *" - To run scheduler every Hour
    // cron = "0 * * ? * *" - To run scheduler every Hour
    @Scheduled(cron = "0 * * ? * *") // run scheduler every Hour
    public void UserRecordScheduler() {
        // Delete existing user records
        userService.deleteAllUserSchedulerJob();
        logger.info("deleteAllUserSchedulerJob() Scheduler run time is :: " + Calendar.getInstance().getTime());

        // Call UserData Util function to get all newly generated user records
        List<User> userList = UserData.generateUserData();

        // save newly generated user records to database
        userService.generateNewUserDataScheduler(userList);
      logger.info("generateNewUserDataScheduler() Scheduler run time is :: "+ Calendar.getInstance().getTime());

    }


}
