package com.foodFly.master.Controller;

import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.DTOs.RestaurantResponseDto;
import com.foodFly.master.Model.Restaurant;
import com.foodFly.master.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/registerRestaurant")
    public ResponseEntity<Restaurant> registerRestaurantController(@RequestBody RestaurantRequestDto restaurantRequestDto){

        Restaurant restaurant  = restaurantService.registerRestaurant(restaurantRequestDto);
        return  new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

   @GetMapping("/getRestaurant")
    public ResponseEntity<Restaurant> getRestaurantController(@RequestParam Long restaurantId){

       Restaurant response = restaurantService.getRestaurant(restaurantId);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/updateRestaurant")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto){

        Restaurant response = restaurantService.updateRestaurant(restaurantRequestDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    public ResponseEntity<String> deleteRestaurant(@RequestParam Long restaurantId){

        String response = restaurantService.deleteRestaurant(restaurantId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
