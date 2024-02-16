package com.frost.gasgo.userhub.wrapper;

import com.frost.gasgo.userhub.entity.UserData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDataWrapper {
    private Long addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private Long pincode;
}
