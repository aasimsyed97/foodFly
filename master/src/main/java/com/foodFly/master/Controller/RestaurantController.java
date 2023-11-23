package com.foodFly.master.Controller;

import com.foodFly.master.DTOs.RestaurantRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {


    @PostMapping("/registerRestaurant")
    public ResponseEntity<String> registerRestaurantController(@RequestBody RestaurantRequestDto restaurantRequestDto){


        return  null;
    }

}
