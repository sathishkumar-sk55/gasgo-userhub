package com.frost.gasgo.userhub.service;

import com.frost.gasgo.userhub.entity.UserData;
import com.frost.gasgo.userhub.repository.UserDataRepository;
import com.frost.gasgo.userhub.wrapper.UserDataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl {
    @Autowired
    private UserDataRepository userDataRepository;

    public UserData addUser(UserData userData) {
        return userDataRepository.save(userData);
    }

    public UserDataWrapper getUserDataById(Long userId) {
        UserData userData =  userDataRepository.findById(userId).get();
        UserDataWrapper userDataWrapper =
                UserDataWrapper
                        .builder()
                        .userId(userData.getUserId())
                        .username(userData.getUsername())
                        .firstName(userData.getFirstName())
                        .lastName(userData.getLastName())
                        .build();
        return userDataWrapper;
    }
}
