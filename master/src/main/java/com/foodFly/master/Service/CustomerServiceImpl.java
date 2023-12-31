package com.foodFly.master.Service;


import com.foodFly.master.DAO.*;
import com.foodFly.master.DTOs.AddressRequestDto;
import com.foodFly.master.DTOs.CustomerRequestDto;
import com.foodFly.master.DTOs.CustomerResponseDto;
import com.foodFly.master.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    AddressDao addressDao;

    @Autowired
    CustomerAddressMappingDao customerAddressMappingDao;

    @Autowired
    FoodCartDao foodCartDao;

    @Autowired
    CustomerCartMappingDao customerCartMappingDao;

    @Autowired
    ItemCartMappingDao itemCartMappingDao;

    @Autowired
    ItemDao itemDao;


    @Override
    public CustomerResponseDto getCustomer(Long id) {
        Customer customer = customerDao.getReferenceById(id);
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
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
        FoodCart foodCart = new FoodCart();
        foodCart.setTotal_Amount(0.00);

        foodCart = foodCartDao.save(foodCart);
        CustomerCartMapping customerCartMapping = new CustomerCartMapping();
        customerCartMapping.setFoodCartId(foodCart.getFoodCartId());
        customerCartMapping.setCustomerId(customer.getCustomerId());

        customerCartMappingDao.save(customerCartMapping);

        Address address = getAddress(customerRequestDto);

        address = addressDao.save(address);

        CustomerAddressMapping customerAddressMapping = new CustomerAddressMapping();
        customerAddressMapping.setCustomerId(customer.getCustomerId());
        customerAddressMapping.setAddressId(address.getAddressId());
        customerAddressMapping = customerAddressMappingDao.save(customerAddressMapping);

        if (!Objects.isNull(customerAddressMapping.getUuid())) {
            return "Customer saved succefully";
        }
        return "something went wrong";
    }

    @Override
    public String updateCustomer(CustomerRequestDto customerRequestDto, Long customerId) {
           Customer customer = customerDao.getReferenceById(customerId);

            Customer customerReq = getCustomer(customerRequestDto);
            customerReq.setCustomerId(customer.getCustomerId());
            customerReq = customerDao.save(customerReq);

        return "Customer updated successfully";
    }

    @Override
    public String updateCustomerAddressController(AddressRequestDto addressRequestDto, Long customerId) {
        Address address = getAddress(addressRequestDto);
        address = addressDao.save(address);

        return "address updated with id "+address.getAddressId();
    }

    @Override
    public String deleteCustomerAddress(Long customerId,Long addressId){
        addressDao.deleteById(addressId);
        customerAddressMappingDao.deleteByCustomerIdAndAddressId(customerId,addressId);
        return "CustomerAddress deleted successfully";
    }

    @Override
    public String deleteCustomer(Long customerId) {
        customerDao.deleteById(customerId);
        List<CustomerAddressMapping>  customerAddressMappings = customerAddressMappingDao.findAllByCustomerId(customerId);
         List<Long> addressIds = new ArrayList<>();
        customerAddressMappings.forEach((model)->{
                addressIds.add(model.getAddressId());
                customerAddressMappingDao.deleteByCustomerIdAndAddressId(customerId,model.getAddressId());
        });
         addressIds.forEach(i->addressDao.deleteById(i));

        return "customer deleted successfully";
    }

    @Override
    public Map<FoodCart, List<Item>> updateFoodCartItem(Long customerId, Long itemId) {
        Long  cartId = customerCartMappingDao.findFoodCartIdByCustomerId(customerId);
       Optional <FoodCart> foodCartOptional = foodCartDao.findById(cartId);
       FoodCart foodCart = new FoodCart();
       if(foodCartOptional.isEmpty()){
          foodCart =  foodCartDao.save(foodCart);
          CustomerCartMapping customerCartMapping = new CustomerCartMapping();
          customerCartMapping.setFoodCartId(foodCart.getFoodCartId());
          customerCartMapping.setCustomerId(customerId);
          customerCartMappingDao.save(customerCartMapping);
       } else {
       foodCart = foodCartOptional.get();
       }
       ItemCartMapping itemCartMapping = new ItemCartMapping();
       itemCartMapping.setFoodCartId(foodCart.getFoodCartId());
       itemCartMapping.setItemId(itemId);
       itemCartMappingDao.save(itemCartMapping);
       List<Long> itemIdList = itemCartMappingDao.findAllItemIdByFoodCartId(foodCart.getFoodCartId());
       List<Item> itemList = itemDao.findAllById(itemIdList);
       Map<FoodCart,List<Item>> foodCartListMap = new HashMap<>();
       foodCartListMap.put(foodCart,itemList);
        return foodCartListMap;
    }

    @Override
    public Map<FoodCart, List<Item>> deleteFoodCartItem(Long customerId, Long itemId, Long foodCartId) {
        FoodCart foodCart = foodCartDao.getReferenceById(foodCartId);
            itemCartMappingDao.deleteByItemIdAndFoodCartId(itemId,foodCartId);
        List<Long> itemIds = itemCartMappingDao.findAllItemIdByFoodCartId(foodCartId);
        List<Item> itemList = itemDao.findAllById(itemIds);
        Map<FoodCart,List<Item>> foodCartListMap = new HashMap<>();
        foodCartListMap.put(foodCart,itemList);
        return foodCartListMap;
    }




    private static Address getAddress(CustomerRequestDto customerRequestDto) {
        Address address = new Address();
        address.setCity(customerRequestDto.getCity());
        address.setState(customerRequestDto.getState());
        address.setCountry(customerRequestDto.getCountry());
        address.setBuilding(customerRequestDto.getBuilding());
        address.setPinCode(customerRequestDto.getPinCode());
        address.setStreet(customerRequestDto.getStreet());

        return address;

    }

    private static Address getAddress(AddressRequestDto addressRequestDto) {
        Address address = new Address();
        address.setCity(addressRequestDto.getCity());
        address.setState(addressRequestDto.getState());
        address.setCountry(addressRequestDto.getCountry());
        address.setBuilding(addressRequestDto.getBuilding());
        address.setPinCode(addressRequestDto.getPinCode());
        address.setStreet(addressRequestDto.getStreet());

        return address;

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
