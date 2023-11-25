package com.foodFly.master.DAO;

import com.foodFly.master.Model.CustomerAddressMapping;
import com.foodFly.master.Model.RestaurantAddressMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RestaurantAddressMappingDao extends JpaRepository<RestaurantAddressMapping, UUID> {

    void deleteByRestaurantIdAndAddressId(Long restaurantId,Long addressId);
    void deleteAllByRestaurantId(Long restaurantId);
    List<RestaurantAddressMapping> findAllByRestaurantId(Long restaurantId);

    List<Long> findAllAddressIdByRestaurantId(Long restaurantId);
}
