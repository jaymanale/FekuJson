package com.springboot.app.fekuAPI.service;

import com.springboot.app.fekuAPI.exception.ResourceNotFoundException;
import com.springboot.app.fekuAPI.model.User;
import com.springboot.app.fekuAPI.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        Collections.sort(userList);
        return userList;

    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User is not found with id : '"+id+"'"));

    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setWebsite(user.getWebsite());

        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteAllUserSchedulerJob() {
        userRepository.deleteAll();
    }
    @Override
    public void generateNewUserDataScheduler(List<User> userList) {
        userRepository.saveAll(userList);
    }

}
