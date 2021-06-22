package com.aynu.service.impl;

import com.aynu.entity.Product;
import com.aynu.entity.ProductCategory;
import com.aynu.mapper.ProductCategoryMapper;
import com.aynu.mapper.ProductMapper;
import com.aynu.service.ProductCategoryService;
import com.aynu.vo.ProductCategoryVo;
import com.aynu.vo.ProductVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cat
 * @since 2021-05-15
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<ProductCategoryVo> getAllProductCategoryVo() {
        //实体类转VO
        //一级分类,条件查询
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type",1);
        List<ProductCategory> l1 = productCategoryMapper.selectList(wrapper);

        List<ProductCategoryVo> l1VO  = l1.stream()
                .map(e -> new ProductCategoryVo(e.getId(),e.getName())).collect(Collectors.toList());
        //图片赋值
        //商品信息赋值
        for (int i = 0; i < l1VO.size(); i++) {
            l1VO.get(i).setBannerImg("/images/banner"+i+".png");
            l1VO.get(i).setTopImg("/images/top"+i+".png");
            //商品信息赋值
            wrapper = new QueryWrapper();
            wrapper.eq("categorylevelone_id",l1VO.get(i).getId());
            List<Product> productList = productMapper.selectList(wrapper);
            List<ProductVO> productVOList = productList.stream()
                    .map(e -> new ProductVO(
                            e.getId(),
                            e.getName(),
                            e.getPrice(),
                            e.getFileName()
                    )).collect(Collectors.toList());
            l1VO.get(i).setProductVOList(productVOList);

        }


        //二级分类
        for (ProductCategoryVo productCategoryVO:l1VO){
            wrapper = new QueryWrapper();
            wrapper.eq("type",2);
            wrapper.eq("parent_id",productCategoryVO.getId());
            List<ProductCategory> l2 = productCategoryMapper.selectList(wrapper);
            List<ProductCategoryVo> l2VO = l2.stream().map(e -> new ProductCategoryVo(e.getId(),e.getName())).collect(Collectors.toList());
            productCategoryVO.setChildren(l2VO);
            //三级分类
            for (ProductCategoryVo productCategoryVO2:l2VO){
                wrapper = new QueryWrapper();
                wrapper.eq("type",3);
                wrapper.eq("parent_id",productCategoryVO2.getId());
                List<ProductCategory> l3 = productCategoryMapper.selectList(wrapper);
                List<ProductCategoryVo> l3VO = l3.stream().map(e -> new ProductCategoryVo(e.getId(),e.getName())).collect(Collectors.toList());
                productCategoryVO2.setChildren(l3VO);
            }
        }

        return l1VO;
    }
}
