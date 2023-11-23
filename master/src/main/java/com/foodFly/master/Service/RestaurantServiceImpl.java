package com.foodFly.master.Service;

import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.DTOs.RestaurantResponseDto;
import com.foodFly.master.Model.Restaurant;
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

     private Restaurant getRestaurant(RestaurantRequestDto restaurantRequestDto){

        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantRequestDto.getRestaurantName());
        restaurant.setCategory(restaurantRequestDto.getCategory());
        restaurant.setEmail(restaurantRequestDto.getEmail());
        restaurant.setPassword(restaurantRequestDto.getPassword());
        restaurant.setManagerName(restaurantRequestDto.getManagerName());
        restaurant.setMobileNumber(restaurantRequestDto.getMobileNumber());
        return restaurant;
     }
}
