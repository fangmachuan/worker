package com.aynu.vo;

import lombok.Data;

@Data
public class OrderDetailVO {
    private Integer id;
    private String name;
    private Float cost;
    private Integer quantity;
    //图片
    private String fileName;
    private String address;
}
