package com.foodFly.master.DTOs;

import com.foodFly.master.Model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDto {


    private String mobileNumber;
    private String email;
    private String managerName;

    private String password;
    private String restaurantName;

    private List<Address> addressesList;

    private Enum Category;
}
