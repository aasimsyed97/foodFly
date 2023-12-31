package com.foodFly.master.Controller;

import com.foodFly.master.DTOs.AddressRequestDto;
import com.foodFly.master.DTOs.CustomerRequestDto;
import com.foodFly.master.DTOs.CustomerResponseDto;
import com.foodFly.master.Model.FoodCart;
import com.foodFly.master.Model.Item;
import com.foodFly.master.Service.CustomerService;
import com.foodFly.master.Service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController("customer")
public class CustomerController {

    /*
    register customer
    get customer by id
    delete customer
    update cutomer

     */
    @Autowired
    CustomerService customerService;


    @GetMapping("/getCustomer/")
    ResponseEntity<CustomerResponseDto> getCustomerByIdController(@RequestParam(value = "id",required = true) Long id ){

        CustomerResponseDto customerResponseDto =  customerService.getCustomer(id);
          return  new ResponseEntity<>(customerResponseDto, HttpStatus.OK);

      }

    @PostMapping("/registerCustomer")
    ResponseEntity<String> registerCustomerController(@RequestBody CustomerRequestDto customerRequestDto){
        String userName = customerService.registerCustomer(customerRequestDto);
        return new ResponseEntity<>(userName,HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer")
    ResponseEntity<String> updateCustomerController(@RequestBody CustomerRequestDto customerRequestDto, @RequestParam Long customerId){
        String userName =  customerService.updateCustomer(customerRequestDto,customerId);
        return  new ResponseEntity<>(userName,HttpStatus.OK);
    }

    @PostMapping("updateAddress")
    ResponseEntity<String> updateCustomerAddressController(@RequestParam Long customerId,
            @RequestBody AddressRequestDto addressRequestDto){
       String  res = customerService.updateCustomerAddressController(addressRequestDto,customerId);

       return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress")
    ResponseEntity<String> deleteCustomerAddressController(@RequestParam Long customerId,@RequestParam Long addressId){
         String res = customerService.deleteCustomerAddress(customerId,addressId);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer")
    ResponseEntity<String> deleteCustomerController(@RequestParam Long customerId){
         String res = customerService.deleteCustomer(customerId);
         return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PutMapping("/updateCart")
    public ResponseEntity<Map<FoodCart, List<Item>>>updateFoodCartController(@RequestParam Long customerId, @RequestParam Long itemId){
        Map<FoodCart,List<Item>> foodCartListMap = customerService.updateFoodCartItem(customerId,itemId);
        return new ResponseEntity<>(foodCartListMap,HttpStatus.OK);
    }

    @DeleteMapping("/deleteItemFromCart")
    public ResponseEntity<Map<FoodCart,List<Item>>>deleteItemFromCartController(
            @RequestParam Long customerId,@RequestParam Long itemId, @RequestParam Long foodCartId){
        Map<FoodCart,List<Item>> foodCartListMap = customerService.deleteFoodCartItem(customerId,itemId,foodCartId);
        return new ResponseEntity<>(foodCartListMap,HttpStatus.OK);
    }


}
