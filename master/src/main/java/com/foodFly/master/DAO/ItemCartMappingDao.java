package com.foodFly.master.DAO;

import com.foodFly.master.Model.ItemCartMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemCartMappingDao extends JpaRepository<ItemCartMapping, UUID> {
    List<Long> findAllItemIdByFoodCartId(Long foodCartId);
}
