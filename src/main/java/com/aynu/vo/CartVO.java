package com.aynu.vo;

import lombok.Data;

@Data
public class CartVO {
    private Integer Id;
    private Integer quantity;
    private Float cost;
    //商品信息
    private Integer productId;
    private Float price;
    private String name;
    private String fileName;
    private Integer stock;
}
