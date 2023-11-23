package com.foodFly.master.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RestaurantAddressMapping {

    private UUID uuid;

    private Long restaurantId;
    private Long addressId;

}
