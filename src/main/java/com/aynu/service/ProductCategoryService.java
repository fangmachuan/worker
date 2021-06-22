package com.aynu.service;

import com.aynu.entity.ProductCategory;
import com.aynu.vo.ProductCategoryVo;
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
public interface ProductCategoryService extends IService<ProductCategory> {
    public List<ProductCategoryVo> getAllProductCategoryVo();

}
