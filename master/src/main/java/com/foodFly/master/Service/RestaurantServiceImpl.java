package com.foodFly.master.Service;

import com.foodFly.master.DAO.AddressDao;
import com.foodFly.master.DAO.RestaurantAddressMappingDao;
import com.foodFly.master.DAO.RestaurantDao;
import com.foodFly.master.DTOs.AddressRequestDto;
import com.foodFly.master.DTOs.RestaurantRequestDto;
import com.foodFly.master.Model.Address;
import com.foodFly.master.Model.Restaurant;
import com.foodFly.master.Model.RestaurantAddressMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantDao restaurantDao;

    @Autowired
    AddressDao addressDao;

    @Autowired
    RestaurantAddressMappingDao restaurantAddressMappingDao;

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
            address = addressDao.save(address);
        RestaurantAddressMapping restaurantAddressMapping = new RestaurantAddressMapping();
        restaurantAddressMapping.setAddressId(address.getAddressId());
        restaurantAddressMapping.setRestaurantId(restaurantId);
        restaurantAddressMappingDao.save(restaurantAddressMapping);

        return address;
    }

    @Override
    public String deleteRestaurantAddress(Long restaurantId, Long addressId) {
        addressDao.deleteById(addressId);
        restaurantAddressMappingDao.deleteByRestaurantIdAndAddressId(restaurantId,addressId);

        return "restaurant delete successfully";
    }

    @Override
    public Map<Restaurant, List<Address>> getAllRestaurant() {
         Map<Restaurant, List<Address>> restaurantMap  = new HashMap<>();
         List<Restaurant> restaurantList = restaurantDao.findAll();
         restaurantList.forEach(restaurant -> {
             List<Long> addressIds = restaurantAddressMappingDao.findAllAddressIdByRestaurantId(restaurant.getRestaurantId());
             List<Address> addressList = addressDao.findAllById(addressIds);
             restaurantMap.put(restaurant,addressList);
         });

        return restaurantMap ;
    }

    @Override
    public List<Address> getAllAddress_restaurant(Long restaurantId) {
      List<Long> addressIds =  restaurantAddressMappingDao.findAllAddressIdByRestaurantId(restaurantId);
      List<Address> addressList =  addressDao.findAllById(addressIds);
        return addressList;
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
