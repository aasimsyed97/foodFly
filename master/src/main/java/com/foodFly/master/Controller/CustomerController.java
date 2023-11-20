package com.foodFly.master.Controller;

import com.foodFly.master.DTOs.CustomerRequestDto;
import com.foodFly.master.DTOs.CustomerResponseDto;
import com.foodFly.master.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<CustomerResponseDto> getCustomerById(@RequestParam(value = "id",required = true) Long id ){

        CustomerResponseDto customerResponseDto =  customerService.getCustomer(id);
          return  new ResponseEntity<>(customerResponseDto, HttpStatus.OK);

      }

    @PostMapping("/save")
    ResponseEntity<String> registerCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        String userName = customerService.registerCustomer(customerRequestDto);
        return new ResponseEntity<>(userName,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<String> updateCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        String userName =  customerService.updateCustomer(customerRequestDto);
        return  new ResponseEntity<>(userName,HttpStatus.OK);
    }

}
