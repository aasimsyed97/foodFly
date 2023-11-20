package com.foodFly.master.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private UUID uuid;

    private Long customerId;

    private Long addressId;


}
