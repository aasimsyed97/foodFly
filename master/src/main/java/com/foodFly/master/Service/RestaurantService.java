package com.foodFly.master.Service;

import com.foodFly.master.DTOs.AddressRequestDto;
import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.DTOs.RestaurantResponseDto;
import com.foodFly.master.Model.Address;
import com.foodFly.master.Model.Item;
import com.foodFly.master.Model.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RestaurantService {

    public Restaurant registerRestaurant(RestaurantRequestDto restaurantRequestDto);

    public Restaurant getRestaurant(Long restaurantId);

    public Restaurant updateRestaurant(RestaurantRequestDto restaurantRequestDto);

    public String deleteRestaurant(Long restaurantId);

    public Address updateRestaurantAddress(AddressRequestDto addressRequestDto,Long restaurantId);

    String deleteRestaurantAddress(Long restaurantId, Long addressId);

    Map<Restaurant, Address> getAllRestaurant();



    Address getRestaurantAddress(Long restaurantId);

    Map<Restaurant, List<Item>> getAllRestaurantsItems();
}
