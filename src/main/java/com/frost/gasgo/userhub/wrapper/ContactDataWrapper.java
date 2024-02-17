package com.frost.gasgo.userhub.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDataWrapper {
    private long contactId;
    private String mobileNumber1;
    private String mobileNumber2;
    private String email;

}