package com.frost.gasgo.userhub.controller;

import com.frost.gasgo.userhub.customexpection.UserAlreadyExistException;
import com.frost.gasgo.userhub.customexpection.UserNotFoundException;
import com.frost.gasgo.userhub.entity.UserData;
import com.frost.gasgo.userhub.service.UserDataServiceImpl;
import com.frost.gasgo.userhub.wrapper.UserDataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserDataController {

    @Autowired
    private UserDataServiceImpl userDataService;

    @PostMapping("adduser")
    public ResponseEntity<UserData> addUser(@RequestBody UserData userData) throws UserAlreadyExistException {
        return new ResponseEntity<>(userDataService.addUser(userData),HttpStatus.CREATED);
    }

    @GetMapping("getUser/{userId}")
    public ResponseEntity<UserDataWrapper> getUser(@PathVariable long userId) throws UserNotFoundException {
        System.out.println("user id " + userId);
        return userDataService.getUserDataById(userId);
    }
}
