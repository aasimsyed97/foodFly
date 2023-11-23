package com.foodFly.master.Controller;

import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.DTOs.RestaurantResponseDto;
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
    public ResponseEntity<RestaurantResponseDto> registerRestaurantController(@RequestBody RestaurantRequestDto restaurantRequestDto){

        RestaurantResponseDto restaurantResponseDto = restaurantService.registerRestaurant(restaurantRequestDto);
        return  new ResponseEntity<>(restaurantResponseDto, HttpStatus.CREATED);
    }

   @GetMapping("/getRestaurant")
    public ResponseEntity<RestaurantResponseDto> getRestaurantController(@RequestParam Long restaurantId){

        RestaurantResponseDto responseDto = restaurantService.getRestaurant(restaurantId);

        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    @PutMapping("/updateRestaurant")
    public ResponseEntity<RestaurantResponseDto> updateRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto){

        RestaurantResponseDto responseDto = restaurantService.updateRestaurant(restaurantRequestDto);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }


    public ResponseEntity<String> deleteRestaurant(@RequestParam Long restaurantId){

        String response = restaurantService.deleteRestaurant(restaurantId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
