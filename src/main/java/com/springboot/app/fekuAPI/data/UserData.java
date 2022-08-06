package com.springboot.app.fekuAPI.data;

import com.springboot.app.fekuAPI.model.User;
import com.springboot.app.fekuAPI.util.UtilHelper;
import java.util.ArrayList;
import java.util.List;


public class UserData {
    public static List<User> generateUserData(int count) {

        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {

            String firstName = UtilHelper.faker().name().firstName();
            String lastName = UtilHelper.faker().name().lastName();
            String email = firstName + lastName + "@gmail.com";
            String phoneNumber = UtilHelper.faker().phoneNumber().phoneNumber();
            String website = firstName + lastName + ".com";

            userList.add(new User(
                    (long) i,
                    firstName,
                    lastName,
                    email.toLowerCase(),
                    phoneNumber,
                    website.toLowerCase()
            ));
        }
        return userList;

    }
}
