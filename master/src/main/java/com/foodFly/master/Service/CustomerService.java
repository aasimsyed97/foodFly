package com.foodFly.master.Service;

import com.foodFly.master.DTOs.AddressRequestDto;
import com.foodFly.master.DTOs.CustomerRequestDto;
import com.foodFly.master.DTOs.CustomerResponseDto;
import com.foodFly.master.Model.FoodCart;
import com.foodFly.master.Model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface CustomerService {

   CustomerResponseDto getCustomer(Long id);

   String registerCustomer(CustomerRequestDto customerRequestDto);


  String updateCustomer(CustomerRequestDto customerRequestDto, Long customerId);

   String updateCustomerAddressController(AddressRequestDto addressRequestDto,Long customerId);
   String deleteCustomerAddress(Long customerId,Long addressId);
   String deleteCustomer(Long customerId);

    Map<FoodCart, List<Item>> updateFoodCartItem(Long customerId, Long itemId);

    Map<FoodCart, List<Item>> deleteFoodCartItem(Long customerId, Long itemId, Long foodCartId);
}
