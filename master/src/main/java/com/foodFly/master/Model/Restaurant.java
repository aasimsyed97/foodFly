package com.foodFly.master.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {

    @Id
    private Long restaurantId;

    private String mobileNumber;
    private String email;
    private String managerName;

    private String password;
    private String restaurantName;
    private String Category;



}
