package com.foodFly.master.Service;

import com.foodFly.master.DAO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDao orderDao;
    @Autowired
    FoodCartDao foodCartDao;

    @Autowired
    ItemDao itemDao;

    @Autowired
    RestaurantDao restaurantDao;
    @Autowired
    CustomerDao customerDao;




}
