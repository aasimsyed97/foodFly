package com.foodFly.master.Controller;

import com.foodFly.master.DTOs.AddressRequestDto;
import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.Model.Address;
import com.foodFly.master.Model.Restaurant;
import com.foodFly.master.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    @DeleteMapping("/deleteRestaurant")
    public ResponseEntity<String> deleteRestaurant(@RequestParam Long restaurantId) {
        String response = restaurantService.deleteRestaurant(restaurantId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/updateRestaurantAddress")
    public ResponseEntity<Address> updateRestaurantAddress(@RequestBody AddressRequestDto addressRequestDto,@RequestParam Long restaurantId){

        Address address = restaurantService.updateRestaurantAddress(addressRequestDto,restaurantId);
        return new ResponseEntity<>(address,HttpStatus.OK);
    }

    @DeleteMapping("/deleteRestaurantAddress")
    public ResponseEntity<String> deleteRestaurantAddressController(@RequestParam Long restaurantId, @RequestParam Long addressId){
      String res =   restaurantService.deleteRestaurantAddress(restaurantId,addressId);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/get-All-Restaurant")
    public ResponseEntity<Map<Restaurant,Address>> getAllRestaurantController(){
       Map<Restaurant,Address>  response = restaurantService.getAllRestaurant();
       return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getRestaurantAddress")
    public ResponseEntity<Address> getRestaurantAddressController(@RequestParam Long restaurantId){
      Address  address = restaurantService.getRestaurantAddress(restaurantId);
       return new ResponseEntity<>(address,HttpStatus.OK);
    }
}
