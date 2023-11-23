package com.foodFly.master.Service;

import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.DTOs.RestaurantResponseDto;

public interface RestaurantService {

    public RestaurantResponseDto registerRestaurant(RestaurantRequestDto restaurantRequestDto);

    public RestaurantResponseDto getRestaurant(Long restaurantId);

    public RestaurantResponseDto updateRestaurant(RestaurantRequestDto restaurantRequestDto);

    public String deleteRestaurant(Long restaurantId);

}
