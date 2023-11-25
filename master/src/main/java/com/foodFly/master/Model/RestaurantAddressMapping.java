package com.foodFly.master.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RestaurantAddressMapping {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private Long restaurantId;
    private Long addressId;

}
