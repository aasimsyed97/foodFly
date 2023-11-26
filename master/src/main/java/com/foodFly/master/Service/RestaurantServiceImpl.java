package com.foodFly.master.Service;

import com.foodFly.master.DAO.*;
import com.foodFly.master.DTOs.AddressRequestDto;
import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.Model.Address;
import com.foodFly.master.Model.Item;
import com.foodFly.master.Model.Restaurant;
import com.foodFly.master.Model.RestaurantAddressMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantDao restaurantDao;

    @Autowired
    AddressDao addressDao;

    @Autowired
    RestaurantAddressMappingDao restaurantAddressMappingDao;

    @Autowired
    RestaurantItemMappingDao restaurantItemMappingDao;

    @Autowired
    ItemDao itemDao;

    @Override
    public Restaurant registerRestaurant(RestaurantRequestDto restaurantRequestDto) {
             Restaurant restaurant = getRestaurant(restaurantRequestDto);
             restaurant = restaurantDao.save(restaurant);
             return restaurant;
    }

    @Override
    public Restaurant getRestaurant(Long restaurantId) {
       Restaurant restaurant = restaurantDao.getReferenceById(restaurantId);
        return restaurant;
    }

    @Override
    public Restaurant updateRestaurant(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = getRestaurant(restaurantRequestDto);
        restaurant = restaurantDao.save(restaurant);
        return restaurant;
    }

    @Override
    public String deleteRestaurant(Long restaurantId) {
     List<RestaurantAddressMapping>  list = restaurantAddressMappingDao.findAllByRestaurantId(restaurantId);
      list.forEach(m-> {
          addressDao.deleteById(m.getAddressId());

      });
      restaurantAddressMappingDao.deleteAllByRestaurantId(restaurantId);
        restaurantDao.deleteById(restaurantId);
        return "restaurant deleted sucessfully";
    }

    @Override
    public Address updateRestaurantAddress(AddressRequestDto addressRequestDto,Long restaurantId) {
        Address address = getAddress(addressRequestDto);
        RestaurantAddressMapping response = restaurantAddressMappingDao.findByRestaurantId(restaurantId);
        if(Objects.isNull(response)){
            // In case of create
            address = addressDao.save(address);
            RestaurantAddressMapping addressMapping = new RestaurantAddressMapping();
            addressMapping.setAddressId(address.getAddressId());
            addressMapping.setRestaurantId(restaurantId);
            restaurantAddressMappingDao.save(addressMapping);

        }
        // In case of update
        addressDao.save(address);
        return address;
    }

    @Override
    public String deleteRestaurantAddress(Long restaurantId, Long addressId) {
        addressDao.deleteById(addressId);
        restaurantAddressMappingDao.deleteByRestaurantIdAndAddressId(restaurantId,addressId);

        return "restaurant delete successfully";
    }

    @Override
    public Map<Restaurant, Address> getAllRestaurant() {
         Map<Restaurant, Address> restaurantMap  = new HashMap<>();
         List<Restaurant> restaurantList = restaurantDao.findAll();
         restaurantList.forEach(restaurant -> {
             Long addressId = restaurantAddressMappingDao.findAddressIdByRestaurantId(restaurant.getRestaurantId());
             Optional<Address> addressOptional = addressDao.findById(addressId);
            Address address = new Address();
             if (addressOptional.isPresent()){
                  address = addressOptional.get();
             }

             restaurantMap.put(restaurant,address);
         });

        return restaurantMap ;
    }

    @Override
    public Address getRestaurantAddress(Long restaurantId) {
           Long addressId = restaurantAddressMappingDao.findAddressIdByRestaurantId(restaurantId);
          Optional<Address> addressOptional= addressDao.findById(addressId);
        return addressOptional.orElse(null);
    }

    @Override
    public Map<Restaurant, List<Item>> getAllRestaurantsItems() {
       Map<Restaurant,List<Item>> restaurantItemMap = new HashMap<>();
       List<Restaurant> restaurantList = restaurantDao.findAll();
       restaurantList.forEach(restaurant-> {
          List<Long>  itemIdList = restaurantItemMappingDao.findAllItemIdByRestaurantId(restaurant.getRestaurantId());
          List<Item>  itemList = itemDao.findAllById(itemIdList);
          restaurantItemMap.put(restaurant,itemList);

       });

        return restaurantItemMap;
    }


    private Restaurant getRestaurant(RestaurantRequestDto restaurantRequestDto){

        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantRequestDto.getRestaurantName());
        restaurant.setCategory(restaurantRequestDto.getCategory());
        restaurant.setEmail(restaurantRequestDto.getEmail());
        restaurant.setPassword(restaurantRequestDto.getPassword());
        restaurant.setManagerName(restaurantRequestDto.getManagerName());
        restaurant.setMobileNumber(restaurantRequestDto.getMobileNumber());
        return restaurant;
     }

     private Address getAddress(AddressRequestDto addressRequestDto) {
         Address address = new Address();
         address.setStreet(addressRequestDto.getStreet());
         address.setCity(addressRequestDto.getCity());
         address.setState(addressRequestDto.getState());
         address.setBuilding(addressRequestDto.getBuilding());
         address.setCountry(addressRequestDto.getCountry());
         return address;
     }
}
