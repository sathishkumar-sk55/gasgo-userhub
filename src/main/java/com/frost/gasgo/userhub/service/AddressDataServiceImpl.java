package com.frost.gasgo.userhub.service;

import com.frost.gasgo.userhub.customexpection.UserAlreadyExistException;
import com.frost.gasgo.userhub.customexpection.UserNotFoundException;
import com.frost.gasgo.userhub.entity.AddressData;
import com.frost.gasgo.userhub.entity.UserData;
import com.frost.gasgo.userhub.repository.AddressDataRepository;
import com.frost.gasgo.userhub.repository.UserDataRepository;
import com.frost.gasgo.userhub.wrapper.AddressDataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressDataServiceImpl {

    @Autowired
    UserDataRepository userDataRepository;

    @Autowired
    AddressDataRepository addressDataRepository;

    public ResponseEntity<AddressDataWrapper> addAddress(long userId, AddressData addressData) throws UserNotFoundException {

        UserData userData = userDataRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found address cant be added"));

        addressData.setUserData(userData);
        AddressData savedAddressData = addressDataRepository.save(addressData);

        AddressDataWrapper addressDataWrapper =
                AddressDataWrapper.builder()
                        .addressId(savedAddressData.getAddressId())
                        .addressLine1(savedAddressData.getAddressLine1())
                        .addressLine2(savedAddressData.getAddressLine2())
                        .city(savedAddressData.getCity())
                        .state(savedAddressData.getState())
                        .country(savedAddressData.getCountry())
                        .pincode(savedAddressData.getPincode())
                        .build();


        return ResponseEntity.status(HttpStatus.CREATED).body(addressDataWrapper);
    }

}
