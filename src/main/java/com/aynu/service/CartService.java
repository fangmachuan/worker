package com.aynu.service;

import com.aynu.entity.Cart;
import com.aynu.vo.CartVO;
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
public interface CartService extends IService<Cart> {
    public List<CartVO> findAllCartVOByUserId(Integer id);

}
