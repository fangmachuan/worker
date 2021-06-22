package com.aynu.service;

import com.aynu.entity.Orders;
import com.aynu.entity.User;
import com.aynu.entity.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cat
 * @since 2021-05-15
 */
public interface OrderService extends IService<Orders> {
    public boolean save(Orders orders, User user, UserAddress userAddress);

}
