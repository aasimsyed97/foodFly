package com.foodFly.master.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDto {
    private Double cost;
    private String description;
    private String imgUrl;
    private String itemName;
    private Enum Category;
    private Enum Cuisine;
}
