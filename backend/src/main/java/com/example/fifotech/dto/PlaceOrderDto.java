package com.example.fifotech.dto;

import lombok.Data;

@Data
public class PlaceOrderDto {


    private Long userId;

    private String address;

    private String orderDescription;

}
