package com.foodFly.master.Service;

import com.foodFly.master.DAO.CustomerDao;
import com.foodFly.master.DAO.ItemDao;
import com.foodFly.master.DAO.RestaurantDao;
import com.foodFly.master.DAO.RestaurantItemMappingDao;
import com.foodFly.master.DTOs.ItemRequestDto;
import com.foodFly.master.Model.Item;
import com.foodFly.master.Model.Restaurant;
import com.foodFly.master.Model.RestaurantItemMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
     @Autowired
     ItemDao itemDao;

     @Autowired
    RestaurantDao restaurantDao;

     @Autowired
    CustomerDao customerDao ;

     @Autowired
     RestaurantItemMappingDao restaurantItemMappingDao;


    @Override
    public Item registerItem(ItemRequestDto itemRequestDto,Long restaurantId) {
       Item item = getItem(itemRequestDto);
       item = itemDao.save(item);

       RestaurantItemMapping restaurantItemMapping = new RestaurantItemMapping();
       restaurantItemMapping.setRestaurantId(restaurantId);
       restaurantItemMapping.setItemId(item.getItemId());
       restaurantItemMappingDao.save(restaurantItemMapping);

       return item;
    }

    @Override
    public Item getItem(Long itemId) {
        Optional<Item> itemOptional= itemDao.findById(itemId);
       return itemOptional.orElse(null);
    }

    @Override
    public List<Item> getAllItemByRestaurantid( Long restaurantId) {

        List<Long> itemIds = restaurantItemMappingDao.findAllItemIdByRestaurantId(restaurantId);
        List<Item> itemList = itemDao.findAllById(itemIds);
        return itemList;
    }

    @Override
    public List<Restaurant> getAllRestaurantByItem(Long itemId) {
        List<Long> restaurantIds = restaurantItemMappingDao.findAllRestaurantIdByItemId(itemId);
        List<Restaurant> restaurantList = restaurantDao.findAllById(restaurantIds);
        return restaurantList;
    }

    private Item getItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setItemName(itemRequestDto.getItemName());
        item.setCost(itemRequestDto.getCost());
        item.setCategory(itemRequestDto.getCategory());
        item.setDescription(itemRequestDto.getDescription());
        item.setImgUrl(itemRequestDto.getImgUrl());
        item.setCuisine(itemRequestDto.getCuisine());
        return item;
    }
}
