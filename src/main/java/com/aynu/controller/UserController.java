package com.aynu.controller;


import com.aynu.entity.Orders;
import com.aynu.entity.Product;
import com.aynu.entity.User;
import com.aynu.entity.UserAddress;
import com.aynu.service.CartService;
import com.aynu.service.OrderService;
import com.aynu.service.UserAddressService;
import com.aynu.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("//user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @PostMapping("/register")
    public String register(User user, Model model){
        Boolean result = false;
        System.out.println(user);
        try {
            result = userService.save(user);
        } catch (Exception e) {
            System.out.println("注册错误！！！");
            model.addAttribute("error","<"+user.getLoginName()+" >用户已存在,换一个吧！");
            return "register";
        }

        return result?"login":"register";

    }

    @PostMapping("/login")
    public String login(String loginName, String password, HttpSession session) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("login_Name",loginName);
        wrapper.eq("password",password);
        User user = userService.getOne(wrapper);
        if (user==null){
            session.setAttribute("msg","账号或者密码错误！");
            return "login";
        }else{
            session.setAttribute("user",user);
            return "redirect:/productCategory/list";
        }

    }
    //销毁session
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @GetMapping("/userInfo")
    public ModelAndView userInfo(HttpSession session){
        User user = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userInfo");
        modelAndView.addObject("cartList",cartService.findAllCartVOByUserId(user.getId()));
        return modelAndView;
    }

    @GetMapping("/orderList")
    public String orderList(HttpSession session,Model model,@RequestParam(defaultValue = "1") Integer currentPage){
        User user = (User) session.getAttribute("user");
        model.addAttribute("cartList",cartService.findAllCartVOByUserId(user.getId()));
        Page<Orders> page = new Page(currentPage, 5);
        IPage myorder = orderService.page(page,new QueryWrapper<Orders>().eq("user_id",user.getId()));
        model.addAttribute("myorder",myorder);
        return "orderList";
    }


}

