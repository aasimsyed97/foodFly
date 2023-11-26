package com.foodFly.master.DAO;

import com.foodFly.master.Model.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface FoodCartDao extends JpaRepository<FoodCart,Long> {
}
