package com.foodFly.master.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bill {

    private Long billId;
    private LocalDate billDate;

    private LocalTime billTime;

    private Double totalCost;

    private Integer totalItem;

    private OrderDetails orderDetails;
}
