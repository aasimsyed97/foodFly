package com.foodFly.master.Service;

import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.DTOs.RestaurantResponseDto;
import com.foodFly.master.Model.Restaurant;

public interface RestaurantService {

    public Restaurant registerRestaurant(RestaurantRequestDto restaurantRequestDto);

    public Restaurant getRestaurant(Long restaurantId);

    public Restaurant updateRestaurant(RestaurantRequestDto restaurantRequestDto);

    public String deleteRestaurant(Long restaurantId);

}
