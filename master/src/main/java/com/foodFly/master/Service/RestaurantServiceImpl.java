package com.foodFly.master.Service;

import com.foodFly.master.DAO.AddressDao;
import com.foodFly.master.DAO.RestaurantDao;
import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.DTOs.RestaurantResponseDto;
import com.foodFly.master.Model.Address;
import com.foodFly.master.Model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantDao restaurantDao;

    @Autowired
    AddressDao addressDao;

    @Override
    public Restaurant registerRestaurant(RestaurantRequestDto restaurantRequestDto) {
             Restaurant restaurant = getRestaurant(restaurantRequestDto);
             restaurant = restaurantDao.save(restaurant);
             return restaurant;
    }

    @Override
    public Restaurant getRestaurant(Long restaurantId) {
       Restaurant restaurant = restaurantDao.getReferenceById(restaurantId);
        return restaurant;
    }

    @Override
    public Restaurant updateRestaurant(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = getRestaurant(restaurantRequestDto);
        restaurant = restaurantDao.save(restaurant);
        return restaurant;
    }

    @Override
    public String deleteRestaurant(Long restaurantId) {

        restaurantDao.deleteById(restaurantId);
        return "restaurant deleted sucessfully";
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
