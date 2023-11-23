package com.foodFly.master.DAO;

import com.foodFly.master.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant,Long> {

}
