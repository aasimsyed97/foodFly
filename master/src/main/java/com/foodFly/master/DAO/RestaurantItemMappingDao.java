package com.foodFly.master.DAO;

import com.foodFly.master.Model.Item;
import com.foodFly.master.Model.RestaurantItemMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RestaurantItemMappingDao extends JpaRepository<RestaurantItemMapping, UUID> {

    Long findItemIdByRestaurantId(Long restaurantId);

    Long findRestaurantIdByItemId(Long itemId);

    List<Long> findAllItemByRestaurantId(Long restaurantId);

    List<Long> findAllRestaurantIdByItemId(Long itemId);

    List<Long> findAllItemIdByRestaurantId(Long restaurantId);


}
