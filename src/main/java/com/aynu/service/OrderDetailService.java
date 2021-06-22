package com.aynu.service;

import com.aynu.entity.OrderDetail;
import com.aynu.entity.User;
import com.aynu.vo.OrderDetailVO;
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
public interface OrderDetailService extends IService<OrderDetail> {

    List<OrderDetailVO> findDetail(String serialnumber);
}
