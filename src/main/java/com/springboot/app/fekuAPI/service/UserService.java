package com.springboot.app.fekuAPI.service;

import com.springboot.app.fekuAPI.model.User;

import java.util.List;

public interface UserService {

    //create - save user in Database

    List<User> getUsers();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    // Scheduler Job
    void deleteAllUserSchedulerJob();

    void generateNewUserDataScheduler(List<User> userList);
}
