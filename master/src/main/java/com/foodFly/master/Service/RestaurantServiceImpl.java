package com.foodFly.master.Service;

import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.DTOs.RestaurantResponseDto;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Override
    public RestaurantResponseDto registerRestaurant(RestaurantRequestDto restaurantRequestDto) {
        return null;
    }

    @Override
    public RestaurantResponseDto getRestaurant(Long restaurantId) {
        return null;
    }

    @Override
    public RestaurantResponseDto updateRestaurant(RestaurantRequestDto restaurantRequestDto) {
        return null;
    }

    @Override
    public String deleteRestaurant(Long restaurantId) {
        return null;
    }
}
