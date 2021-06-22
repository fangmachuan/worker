package com.aynu.service.impl;

import com.aynu.entity.OrderDetail;
import com.aynu.entity.Orders;
import com.aynu.entity.Product;
import com.aynu.mapper.OrderDetailMapper;
import com.aynu.mapper.OrderMapper;
import com.aynu.mapper.ProductMapper;
import com.aynu.service.OrderDetailService;
import com.aynu.vo.OrderDetailVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cat
 * @since 2021-05-15
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<OrderDetailVO> findDetail(String serialnumber) {
        if (serialnumber!=null){
            List<OrderDetailVO> detailVOList = new ArrayList<>();
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("serialnumber",serialnumber);
            Orders orders = orderMapper.selectOne(wrapper);
            wrapper=new QueryWrapper();
            wrapper.eq("order_id",orders.getId());
            List<OrderDetail> orderDetailList = orderDetailMapper.selectList(wrapper);
            for (OrderDetail orderDetail : orderDetailList) {
                OrderDetailVO detailVO = new OrderDetailVO();
                detailVO.setAddress(orders.getUserAddress());
                Product product = productMapper.selectById(orderDetail.getProductId());
                BeanUtils.copyProperties(product,detailVO);
                BeanUtils.copyProperties(orderDetail,detailVO);
                detailVOList.add(detailVO);
            }
            return detailVOList;
        }
        return null;

    }
}
