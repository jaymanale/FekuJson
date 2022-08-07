package com.springboot.app.fekuAPI.service;

import com.springboot.app.fekuAPI.exception.ResourceNotFoundException;
import com.springboot.app.fekuAPI.model.PostResponse;
import com.springboot.app.fekuAPI.model.SingleMessage;
import com.springboot.app.fekuAPI.model.User;
import com.springboot.app.fekuAPI.repository.UserRepository;
import com.springboot.app.fekuAPI.util.UtilHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public PostResponse<User> getUsers(Integer pageNumber, Integer pageSize) {

        Pageable pageObj = PageRequest.of(pageNumber, pageSize);
        Page<User> pageableUser = userRepository.findAll(pageObj);
        return UtilHelper.preparePostResponse(pageableUser);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User is not found with id : '" + id + "'"));

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
    public SingleMessage deleteUser(Long id) {

        getUserById(id);
        userRepository.deleteById(id);
        return new SingleMessage("User with ID : " + id + " Deleted Successfully.");
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
