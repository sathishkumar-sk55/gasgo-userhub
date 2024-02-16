package com.frost.gasgo.userhub.controller;

import com.frost.gasgo.userhub.customexpection.UserNotFoundException;
import com.frost.gasgo.userhub.entity.AddressData;
import com.frost.gasgo.userhub.service.AddressDataServiceImpl;
import com.frost.gasgo.userhub.wrapper.AddressDataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class AddressDataController {


    @Autowired
    private AddressDataServiceImpl addressDataService;

    @PostMapping("addAdress/{userId}")
    public ResponseEntity<AddressDataWrapper> addAddress(@PathVariable long userId, @RequestBody AddressData addressData) throws UserNotFoundException {
        return addressDataService.addAddress(userId,addressData);
    }
}
