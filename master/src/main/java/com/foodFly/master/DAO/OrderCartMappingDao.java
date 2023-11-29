package com.foodFly.master.DAO;

import com.foodFly.master.Model.OrderCartMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderCartMappingDao extends JpaRepository<OrderCartMapping, UUID> {
}
