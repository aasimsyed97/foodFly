package com.foodFly.master.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDto {

    private Long restaurantId;

    private String mobileNumber;
    private String email;
    private String managerName;

    private String password;
    private String restaurantName;
    private String Category;
}
