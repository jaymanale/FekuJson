package com.springboot.app.fekuAPI.controller;

import com.springboot.app.fekuAPI.model.PostResponse;
import com.springboot.app.fekuAPI.model.SingleMessage;
import com.springboot.app.fekuAPI.model.User;
import com.springboot.app.fekuAPI.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // Get all USers
    // GET : http://localhost:8080/api/v1/users
    @GetMapping()
    public ResponseEntity<PostResponse<User>> getUsers(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue="id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir

    ) {
        return new ResponseEntity<>(userService.getUsers(pageNumber, pageSize, sortBy, sortDir), HttpStatus.OK);
    }

    // Get User by ID
    // GET : http://localhost:8080/api/v1/users/1
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    // Update User by ID
    // PUT : http://localhost:8080/api/v1/users/1
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SingleMessage> deleteUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.NOT_FOUND);
    }

}
