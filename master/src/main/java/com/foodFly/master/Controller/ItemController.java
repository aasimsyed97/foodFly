package com.foodFly.master.Controller;


import com.foodFly.master.DTOs.ItemRequestDto;
import com.foodFly.master.Model.Item;
import com.foodFly.master.Model.Restaurant;
import com.foodFly.master.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {



    @Autowired
    ItemService itemService;

    @PostMapping("/registerItem")
    public ResponseEntity<Item>  registerItemController(@RequestBody ItemRequestDto itemRequestDto, @RequestParam Long restaurantId){

        Item item =itemService.registerItem(itemRequestDto,restaurantId);

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/getItem")
    public ResponseEntity<Item> getItemController(@RequestParam Long itemId){
        Item item = itemService.getItem(itemId);
        return new ResponseEntity<>(item,HttpStatus.OK);
    }

    @GetMapping("getAllItem-restaurant")
    public ResponseEntity<List<Item>> getAllItemBYRestaurantController( @RequestParam Long restaurantId){
        List<Item> itemList = itemService.getAllItemByRestaurantid(restaurantId);
        return new ResponseEntity<>(itemList,HttpStatus.OK);

    }

    @GetMapping("/getAllRestaurant-item")
    public  ResponseEntity<List<Restaurant>> getAllRestaurantByItemController(@RequestParam Long itemId){
        List<Restaurant> restaurantList = itemService.getAllRestaurantByItem(itemId);
        return new ResponseEntity<>(restaurantList,HttpStatus.OK);
    }

  @DeleteMapping("/deleteItem")
    public ResponseEntity<String> deleteItemFromManuController(@RequestParam Long itemId, @RequestParam Long restaurantId){
       String response =  itemService.deleteItemFromRestaurant(itemId,restaurantId);
       return new ResponseEntity<>(response,HttpStatus.OK);
  }
}

