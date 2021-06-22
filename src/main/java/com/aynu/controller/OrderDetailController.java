package com.aynu.controller;


import com.aynu.entity.User;
import com.aynu.service.CartService;
import com.aynu.service.OrderDetailService;
import com.aynu.vo.OrderDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cat
 * @since 2021-05-15
 */
@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private CartService cartService;
    @Autowired
    private OrderDetailService orderDetailService;


    @GetMapping("/findDetail")
    public ModelAndView findDetail(String serialnumber,HttpSession session){
        User user = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orderDetails");
        List<OrderDetailVO> detailVOList =  orderDetailService.findDetail(serialnumber);
        modelAndView.addObject("detailVOList",detailVOList);
        modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        return modelAndView;
    }



}

