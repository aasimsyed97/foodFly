package com.foodFly.master.Service;


import com.foodFly.master.DAO.AddressDao;
import com.foodFly.master.DAO.CustomerDao;
import com.foodFly.master.DTOs.AddressRequestDto;
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

    @Autowired
    AddressDao addressDao;



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
        Customer customer = getCustomer(customerRequestDto);

       customer = customerDao.save(customer);

        Address address = getAddress(customerRequestDto);

        address =  addressDao.save(address);



        return null;
    }

    @Override
    public String updateCustomer(CustomerRequestDto customerRequestDto) {


        return null;
    }

    @Override
    public String updateCustomerAddressController(AddressRequestDto addressRequestDto, Long customerId) {
        Address address = getAddress(addressRequestDto);
         address = addressDao.save(address);

        return null;
    }

    private static Address getAddress(CustomerRequestDto customerRequestDto){
        Address address  = new Address();
        address.setCity(customerRequestDto.getCity());
        address.setState(customerRequestDto.getState());
        address.setCountry(customerRequestDto.getCountry());
        address.setBuilding(customerRequestDto.getBuilding());
        address.setPinCode(customerRequestDto.getPinCode());
        address.setStreet(customerRequestDto.getStreet());

        return  address;

    }
    private static Address getAddress(AddressRequestDto addressRequestDto){
        Address address  = new Address();
        address.setCity(addressRequestDto.getCity());
        address.setState(addressRequestDto.getState());
        address.setCountry(addressRequestDto.getCountry());
        address.setBuilding(addressRequestDto.getBuilding());
        address.setPinCode(addressRequestDto.getPinCode());
        address.setStreet(addressRequestDto.getStreet());

        return  address;

    }

    private static Customer getCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerRequestDto.getFirstName());
        customer.setLastName(customerRequestDto.getLastName());
        customer.setMobileNumber(customerRequestDto.getMobileNumber());
        customer.setGender(customerRequestDto.getGender());
        customer.setAge(customerRequestDto.getAge());
        customer.setUserName(customerRequestDto.getUserName());
        customer.setPassword(customerRequestDto.getPassword());
        customer.setCustomerEmail(customerRequestDto.getCustomerEmail());
        return customer;
    }

}
