package com.foodFly.master.Service;

import com.foodFly.master.DTOs.ItemRequestDto;
import com.foodFly.master.Model.Item;
import com.foodFly.master.Model.Restaurant;

import java.util.List;

public interface ItemService {

    Item registerItem(ItemRequestDto itemRequestDto, Long restaurantId);

    Item getItem(Long itemId);


    List<Item> getAllItemByRestaurantid( Long restaurantId);

    List<Restaurant> getAllRestaurantByItem(Long itemId);
}
