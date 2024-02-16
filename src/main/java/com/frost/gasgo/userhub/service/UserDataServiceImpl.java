package com.frost.gasgo.userhub.service;

import com.frost.gasgo.userhub.customexpection.UserAlreadyExistException;
import com.frost.gasgo.userhub.customexpection.UserNotFoundException;
import com.frost.gasgo.userhub.entity.UserData;
import com.frost.gasgo.userhub.repository.UserDataRepository;
import com.frost.gasgo.userhub.wrapper.UserDataWrapper;
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

    public ResponseEntity<UserDataWrapper> addUser(UserData userData) throws UserAlreadyExistException {
        try {
            UserData SavedUserData =  userDataRepository.save(userData);

            UserDataWrapper userDataWrapper =
                    UserDataWrapper
                            .builder()
                            .userId(SavedUserData.getUserId())
                            .username(SavedUserData.getUsername())
                            .firstName(SavedUserData.getFirstName())
                            .lastName(SavedUserData.getLastName())
                            .build();


            return ResponseEntity.status(HttpStatus.CREATED).body(userDataWrapper);
        }
        catch (DataIntegrityViolationException exception){
            throw new UserAlreadyExistException("User already exist");
        }
    }

    public ResponseEntity<UserDataWrapper> getUserDataById(Long userId) throws UserNotFoundException {

        UserData userData =  userDataRepository.findById(userId).orElseThrow(() ->new UserNotFoundException("User not found in the DataBase"));

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
