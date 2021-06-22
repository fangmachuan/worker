package com.aynu.controller;


import com.aynu.entity.User;
import com.aynu.entity.UserAddress;
import com.aynu.service.CartService;
import com.aynu.service.UserAddressService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/userAddress")
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;
    @Autowired
    private CartService cartService;


    @GetMapping("/userAddressList")
    public String userAddressList(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("cartList",cartService.findAllCartVOByUserId(user.getId()));
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",user.getId());
        List<UserAddress> addresses = userAddressService.list(wrapper);
        model.addAttribute("addresses",addresses);
        return "userAddressList";
    }

    @GetMapping("/deleteAdd")
    public String deleteAdd(Integer id){
        userAddressService.removeById(id);
        return "redirect:/userAddress/userAddressList";

    }

    @PostMapping("/addAddress")
    public String addAddress(HttpSession session,UserAddress userAddress){
        System.out.println(userAddress);
        User user = (User) session.getAttribute("user");
        userAddressService.save(user,userAddress);
        return "redirect:/userAddress/userAddressList";
    }

}

