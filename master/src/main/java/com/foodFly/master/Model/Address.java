package com.foodFly.master.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private Long addressId;

    private String building;
    private String city;
    private String country;

    private String  pinCode;
    private String state;
    private String street;

}
