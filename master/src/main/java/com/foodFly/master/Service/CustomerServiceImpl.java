package com.foodFly.master.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodFly.master.DAO.CustomerDao;
import com.foodFly.master.DTOs.CustomerRequestDto;
import com.foodFly.master.DTOs.CustomerResponseDto;
import com.foodFly.master.Model.Address;
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

        return null;
    }

    @Override
    public String registerCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerRequestDto.getFirstName());
        customer.setLastName(customerRequestDto.getLastName());
        customer.setMobileNumber(customerRequestDto.getMobileNumber());
        customer.setGender(customerRequestDto.getGender());
        customer.setAge(customerRequestDto.getAge());
        customer.setUserName(customerRequestDto.getUserName());
        customer.setPassword(customerRequestDto.getPassword());
        customer.setCustomerEmail(customerRequestDto.getCustomerEmail());

        customerDao.save(customer);

        Address address = new Address();
        address.setCity(customerRequestDto.getCity());
        address.setState(customerRequestDto.getState());
        address.setCountry(customerRequestDto.getCountry());
        address.setBuilding(customerRequestDto.getBuilding());
        address.setPinCode(customerRequestDto.getPinCode());
        address.setStreet(customerRequestDto.getStreet());


        return null;
    }

    @Override
    public String updateCustomer(CustomerService customerService) {
        return null;
    }
}
