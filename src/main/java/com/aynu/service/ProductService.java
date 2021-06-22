package com.aynu.service;

import com.aynu.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cat
 * @since 2021-05-15
 */
public interface ProductService extends IService<Product> {
    public List<Product> findByCategoryId(String type,Integer categoryId);
}
