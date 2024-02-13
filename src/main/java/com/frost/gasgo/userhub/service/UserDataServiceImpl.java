package com.frost.gasgo.userhub.service;

import com.frost.gasgo.userhub.customexpection.UserAlreadyExistException;
import com.frost.gasgo.userhub.customexpection.UserNotFoundException;
import com.frost.gasgo.userhub.entity.UserData;
import com.frost.gasgo.userhub.repository.UserDataRepository;
import com.frost.gasgo.userhub.wrapper.UserDataWrapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataServiceImpl {
    @Autowired
    private UserDataRepository userDataRepository;

    public UserData addUser(UserData userData) throws UserAlreadyExistException {
        try {
            return userDataRepository.save(userData);
        }
        catch (DataIntegrityViolationException exception){

            throw new UserAlreadyExistException("User already exist");
        }


    }

    public ResponseEntity<UserDataWrapper> getUserDataById(Long userId) throws UserNotFoundException {

        Optional<UserData> user =  userDataRepository.findById(userId);
        if (user.isEmpty()){
            throw new UserNotFoundException("User not found in the DataBase");
        }
        UserData userData = user.get();
        UserDataWrapper userDataWrapper =
                UserDataWrapper
                        .builder()
                        .userId(userData.getUserId())
                        .username(userData.getUsername())
                        .firstName(userData.getFirstName())
                        .lastName(userData.getLastName())
                        .build();
        return new ResponseEntity<UserDataWrapper>(userDataWrapper,HttpStatus.OK);
    }
}
