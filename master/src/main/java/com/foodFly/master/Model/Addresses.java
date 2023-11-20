package com.foodFly.master.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Addresses {

    @Id
    private Long addressId;

    private String building;
    private String city;
    private String country;

    private String  pincode;
    private String state;
    private String street;

}
