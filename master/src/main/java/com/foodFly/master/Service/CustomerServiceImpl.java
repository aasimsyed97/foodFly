package com.foodFly.master.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodFly.master.DAO.CustomerDao;
import com.foodFly.master.DTOs.CustomerRequestDto;
import com.foodFly.master.DTOs.CustomerResponseDto;
import com.foodFly.master.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDao customerDao;

    @Override
    public CustomerResponseDto getCustomer(Long id) {
        Customer customer = customerDao.getReferenceById(id);
        CustomerResponseDto  customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setCustomerEmail(customer.getCustomerEmail());
        customerResponseDto.setAge(customerResponseDto.getAge());
         customerResponseDto.setGender(customer.getGender());
         customerResponseDto.setCustomerId(customer.getCustomerId());
         customerResponseDto.setLastName(customer.getLastName());
         customerResponseDto.setMobileNumber(customer.getMobileNumber());
         customerResponseDto.setFirstName(customer.getFirstName());
         customerResponseDto.setUserName(customer.getUserName());
         Customer
        return null;
    }

    @Override
    public String registerCustomer(CustomerRequestDto customerRequestDto) {
        return null;
    }

    @Override
    public String updateCustomer(CustomerService customerService) {
        return null;
    }
}
