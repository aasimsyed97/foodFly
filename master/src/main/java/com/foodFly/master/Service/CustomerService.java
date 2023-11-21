package com.foodFly.master.Service;

import com.foodFly.master.DTOs.AddressRequestDto;
import com.foodFly.master.DTOs.CustomerRequestDto;
import com.foodFly.master.DTOs.CustomerResponseDto;
import org.springframework.stereotype.Service;


public interface CustomerService {

   CustomerResponseDto getCustomer(Long id);

   String registerCustomer(CustomerRequestDto customerRequestDto);


  String updateCustomer(CustomerRequestDto customerRequestDto);

   String updateCustomerAddressController(AddressRequestDto addressRequestDto,Long customerId);
}
