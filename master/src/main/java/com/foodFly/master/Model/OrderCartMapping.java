package com.foodFly.master.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCartMapping {
    private UUID uuid;
    private UUID orderId;
    private Long foodCartId;

}
