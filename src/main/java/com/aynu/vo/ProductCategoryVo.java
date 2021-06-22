package com.aynu.vo;

import lombok.Data;

import java.util.List;

@Data
public class ProductCategoryVo {
    private Integer id;
    private String name;
    private List<ProductCategoryVo> children;
    private String bannerImg;
    private String topImg;
    private List<ProductVO> productVOList;

    public ProductCategoryVo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
