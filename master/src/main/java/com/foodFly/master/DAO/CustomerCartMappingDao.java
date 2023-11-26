package com.foodFly.master.DAO;

import com.foodFly.master.Model.CustomerCartMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerCartMappingDao extends JpaRepository<CustomerCartMapping, UUID> {
    Long findFoodCartIdByCustomerId(Long customerId);
}
