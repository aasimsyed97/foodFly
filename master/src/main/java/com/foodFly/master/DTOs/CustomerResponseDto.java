package com.foodFly.master.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
    private Long customerId;

    private int age;

    private String customerEmail;

    private String firstName;

    private String lastName;

    private String userName;

    private String gender;

    private String mobileNumber;



    private String building;
    private String city;
    private String country;

    private String  pinCode;
    private String state;
    private String street;

}
