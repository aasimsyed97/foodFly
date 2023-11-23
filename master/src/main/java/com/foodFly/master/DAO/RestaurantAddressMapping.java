package com.foodFly.master.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantAddressMapping extends JpaRepository<RestaurantAddressMapping, UUID> {
}
